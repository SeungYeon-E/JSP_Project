package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.NoticeDto;

public class NoticeDao {
	
DataSource dataSource;
	
	public NoticeDao() {
		try {
			Context context =new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//NOTICE 작성
	public void write(String N_TITLE, String N_CONTENT, String myEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		int n_num = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into notice(N_TITLE, N_CONTENT) values(?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, N_TITLE);
			preparedStatement.setString(2, N_CONTENT);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			query = "SELECT LAST_INSERT_ID()";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				n_num = resultset.getInt(1);
				System.out.println("list-count success");
			}
			preparedStatement.close();
			query = "insert into write_notice(user_email, notice_n_num, nw_regist) values(?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, myEmail);
			preparedStatement.setInt(2, n_num);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//정상적으로 끝나도, 에러가 걸려도 무조건 이쪽을 거친다.
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//notice 쓴 것 읽기
	public NoticeDto read(String strN_NUM) {
		NoticeDto noticeDto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from notice where N_NUM = ?"; //select 문에 ?을 쓰는 것은 보안상 쓰는 것이다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strN_NUM));
			resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					int N_NUM = resultSet.getInt("N_NUM"); //숫자 적어도 무관
					String N_TITLE = resultSet.getString("N_TITLE");
					String N_CONTENT = resultSet.getString("N_CONTENT");
				
					noticeDto = new NoticeDto(N_NUM, N_TITLE, N_CONTENT);//return을 하기 위해 밑에 데이터를 사용함
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//정상적으로 끝나도, 에러가 걸려도 무조건 이쪽을 거친다.
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return noticeDto;
	}
	
		//NOTICE 수정
		public void update(String strN_NUM, String N_TITLE, String N_CONTENT) {
			int N_NUM = Integer.parseInt(strN_NUM);
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "update notice set N_TITLE = ? , N_CONTENT = ? where N_NUM = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, N_TITLE);
				preparedStatement.setString(2, N_CONTENT);
				preparedStatement.setInt(3, N_NUM);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				query = "UPDATE write_notice SET NW_EDIT = now() WHERE NOTICE_N_NUM = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, N_NUM);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//정상적으로 끝나도, 에러가 걸려도 무조건 이쪽을 거친다.
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		 

}//-----------------------