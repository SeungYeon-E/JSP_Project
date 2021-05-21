package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ContentItemdto;

public class ContentItemdao {
	DataSource dataSource;

	public ContentItemdao() {
		try {
			Context context1 = new InitialContext();
			dataSource = (DataSource) context1.lookup("java:comp/env/jdbc/jsp_project");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시물 클릭시 상세페이지
	public ContentItemdto contentView(String strID) {
		ContentItemdto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
//				System.out.println(dataSource1);
			connection = dataSource.getConnection();

			String query = "select * from item i, write_item w, user u where u.email = w.user_email  and i.i_num = w.item_i_num and i.i_num = ?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			if (resultset.next()) {
				int iNo = resultset.getInt("I_NUM");
				String userEmail = resultset.getString("USER_EMAIL");
				String userName = resultset.getString("NAME");
				String iTitle = resultset.getString("I_TITLE");
				String iContent = resultset.getString("I_CONTENT");
				String iImg = resultset.getString("I_IMAGE");
				// 굳이 이미지 가져올 필요가 없어
				String iCategory = resultset.getString("I_CATEGORY");
				int iHits = resultset.getInt("i_hits");
//				int pLike = resultset.getInt("pLike");// Like수없나요?
				Date wRegistDate = resultset.getDate("iw_regist");
				// 이미지 출력을 위함
				iContent = imgcontent(iContent, iImg);
//				System.out.println(pContent);
				dto = new ContentItemdto(iNo, userName, userEmail, iTitle, iContent, iImg, iCategory, iHits, wRegistDate);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return dto;
	}

	// 이미치 출력을 위함
	public String imgcontent(String content, String img) {

		String[] arr_img = img.split(",");
		// ,으로 구분하기, 필요없을거같아
		// 오늘 소개할 물건은\n<img_id=macBook.png>\n<img_id=macBook2.png>\n입니다.
		// 오늘 소개할
		// 물건은\n<img_src=\"http://localhost:8080/DeveloperWeb/img/macBook.png>\n<img_id=macBook2.png\">\n입니다.
		// 변경해준다
		content = content.replaceAll("img_id=", "img src=\"http://localhost:8080/DeveloperWeb/img/");
		content = content.replaceAll("png", "png\"");
		content = content.replaceAll("jpg", "jpg\"");

		return content;
	}

	// 게시물 삭제!!
	public String contentDelete(String strID) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update write_item set iw_delete = now() where item_i_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			preparedStatement.executeUpdate();
			result = "true";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
			}
		}
		return result;
	}

	// 게시물 리뷰 작성
	public void commentWrite(String itemInfo_iNo, String userid, String cContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into comment_item (user_email, item_i_num, ic_content, ic_regist) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, itemInfo_iNo);
			preparedStatement.setString(3, cContent);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	// 게시물 리뷰 Lsit
	public ArrayList<ContentItemdto> commentSelect(String bId, int start, int pageCnt) {
		ArrayList<ContentItemdto> dtos = new ArrayList<ContentItemdto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		//page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
		try {
//			System.out.println(dataSource1);
			connection = dataSource.getConnection();
			// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력
			String query = "select * from comment_item i, user u where  item_i_num = ? and u.email = i.user_email and ic_delete is null ORDER BY ic_num DESC LIMIT ?, ?";
			
			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			preparedStatement.setInt(1, Integer.parseInt(bId));
			if (offset == 0) {
				preparedStatement.setInt(2, offset);
			} else {
				preparedStatement.setInt(2, offset * pageCnt);
			}
			preparedStatement.setInt(3, pageCnt);
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			while (resultset.next()) {
				int ccNo = resultset.getInt("ic_num");
				String username = resultset.getString("name");
				String userEmail = resultset.getString("user_email");
				String cContent = resultset.getString("ic_content");
				Date cRegistDate = resultset.getDate("ic_regist");

				ContentItemdto dto = new ContentItemdto(ccNo, username, userEmail, cContent, cRegistDate);
				dtos.add(dto);
//					System.out.println("cContent="+cContent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return dtos;
	}

	// list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	public int selectCommnetCnt(String itemInfo_iNo) {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from comment_item where item_i_num = ? and ic_delete is null";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(itemInfo_iNo));
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				count = resultset.getInt(1);
				System.out.println("list-count success");
			}

		} catch (Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("< rs, psmt, conn close Fail>");

			}
		}
		return count;
	}
	
		// 상세페이지 리뷰 수정하기 클릭시 상세페이지
		public ContentItemdto commentContent(String ic_Num) {
			ContentItemdto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultset = null;

			try {
				connection = dataSource.getConnection();

				String query = "SELECT * FROM comment_item where ic_num = ?";

				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(ic_Num));
				resultset = preparedStatement.executeQuery();

				if (resultset.next()) {
					int ic_num = resultset.getInt("ic_num");
					String ic_content = resultset.getString("ic_content");
					dto = new ContentItemdto(ic_num, ic_content);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// 정리 다시 거꾸로 정리해주는것
					if (resultset != null)
						resultset.close();
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
			return dto;
		}

	// 게시물 리뷰 수정
	public void commentModiey(String ccNo, String cContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update	comment_item set ic_content = ?, ic_edit = now() where ic_num = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, cContent);
			preparedStatement.setInt(2, Integer.parseInt(ccNo));
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	// 게시물 리뷰 삭제
	public void commentDelete(String ic_num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update comment_item set ic_delete = now() where ic_num = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(ic_num));
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}
