package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
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

			String query = "select * from\n" + "iteminfo i, wwrite w\n" + "where i.iNo = w.itemInfo_iNo\n" + "and i.iNo = ? ;";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			if (resultset.next()) {
				int iNo = resultset.getInt("iNo");
				String userEmail = resultset.getString("user_email");
				String iTitle = resultset.getString("iTitle");
				String iContent = resultset.getString("iContent");
				String iImg = resultset.getString("iImg");
				// 굳이 이미지 가져올 필요가 없어
				String iCategory = resultset.getString("iCategory");
				int iHits = resultset.getInt("iHits");
//				int pLike = resultset.getInt("pLike");// Like수없나요?
				Timestamp wRegistDate = resultset.getTimestamp("wRegistDate");
				//이미지 출력을 위함	
				iContent = imgcontent(iContent, iImg);
//				System.out.println(pContent);
				dto = new ContentItemdto(iNo, userEmail, iTitle, iContent, iImg, iCategory, iHits, wRegistDate);

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
		// 오늘 소개할 물건은\n<img_src=\"http://localhost:8080/DeveloperWeb/img/macBook.png>\n<img_id=macBook2.png\">\n입니다.
		// 변경해준다
		content = content.replaceAll("img_id=", "img src=\"http://localhost:8080/DeveloperWeb/img/");
		content = content.replaceAll("png", "png\"");
		content = content.replaceAll("jpg", "jpg\"");

		return content;
	}
	
	public void contentDelete(String strID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update wwrite set wDelDate = now() where itemInfo_iNo = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
	}

	// 게시물 리뷰 작성
	public void commentWrite(String itemInfo_iNo, String userid, String cContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into ccomment (user_email, itemInfo_iNo, cContent, cRegistDate) values (?,?,?,now())";
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
	//게시물 삭제 dao
	public ArrayList<ContentItemdto> commentSelect(String bId) {
		ArrayList<ContentItemdto> dtos = new ArrayList<ContentItemdto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
//				System.out.println(dataSource1);
			connection = dataSource.getConnection();

			String query = "select * from ccomment\n" + "where itemInfo_iNo = ? ;";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultset = preparedStatement.executeQuery();

//				System.out.println(resultset);
			while (resultset.next()) {
				int ccNo = resultset.getInt("ccNo");
				String userEmail = resultset.getString("user_email");
				String cContent = resultset.getString("cContent");
				Timestamp cRegistDate = resultset.getTimestamp("cRegistDate");

				ContentItemdto dto = new ContentItemdto(ccNo, userEmail, cContent, cRegistDate);
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
}
