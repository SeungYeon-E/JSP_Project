package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.AdminUserdto;

public class AdminUserdao {
	DataSource dataSource;

	public AdminUserdao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// user List
	public ArrayList<AdminUserdto> userSelect(int start, int pageCnt) {
		ArrayList<AdminUserdto> dtos = new ArrayList<AdminUserdto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		// page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
		try {
//				System.out.println(dataSource1);
			connection = dataSource.getConnection();
			// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력
			String query = "select * from user ORDER BY createdate DESC LIMIT ?, ?";

			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			if (offset == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset * pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			resultset = preparedStatement.executeQuery();

//			System.out.println(resultset);
			while (resultset.next()) {
				String email = resultset.getString("email");
				String name = resultset.getString("name");
				String adress = resultset.getString("adress");
				String tel = resultset.getString("tel");
				String git = resultset.getString("git");
				Date createdate = resultset.getDate("createdate");
				Date deletedate = resultset.getDate("deletedate");
				int admin = resultset.getInt("admin");

				AdminUserdto dto = new AdminUserdto(email, name, adress, tel, git, createdate, deletedate, admin);
				dtos.add(dto);
//						System.out.println("cContent="+cContent);
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
	public int selectUserCnt() {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from user";

			preparedStatement = connection.prepareStatement(query);
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

	// user recover 수정
	public String userRecover(String user_email) {
		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update user set deletedate = NULL where email = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user_email);
			preparedStatement.executeUpdate();
			result = "true";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(result);
		} finally {
			try {
				// 정리 다시 거꾸로 정리해주는것
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				System.out.println("< rs, psmt, conn close success>");
			} catch (Exception e) {
				e.printStackTrace();
				result = "false";
				System.out.println("< rs, psmt, conn close Fail>");
			}
		}
		return result;
	}

	// user 삭제
	public String userDelete(String user_email) {

		String result = "false";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update user set deletedate = now() where email = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user_email);
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

	// user search List
	public ArrayList<AdminUserdto> userSelect2(String searching, int start, int pageCnt) {
		ArrayList<AdminUserdto> dtos = new ArrayList<AdminUserdto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		// page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
		try {
//					System.out.println(dataSource1);
			connection = dataSource.getConnection();
			// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력
			String query = "select * from user where NAME LIKE '%" + searching + "%' or email LIKE '%" + searching +"%' ORDER BY createdate DESC LIMIT ?, ?";

			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			if (offset == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset * pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				String email = resultset.getString("email");
				String name = resultset.getString("name");
				String adress = resultset.getString("adress");
				String tel = resultset.getString("tel");
				String git = resultset.getString("git");
				Date createdate = resultset.getDate("createdate");
				Date deletedate = resultset.getDate("deletedate");
				int admin = resultset.getInt("admin");

				AdminUserdto dto = new AdminUserdto(email, name, adress, tel, git, createdate, deletedate, admin);
				dtos.add(dto);
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

	// search list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	public int selectUserCnt2(String searching) {
		int count = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from user where NAME LIKE '%" + searching + "%' or email LIKE '%" + searching + "%'";

			preparedStatement = connection.prepareStatement(query);
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
}
