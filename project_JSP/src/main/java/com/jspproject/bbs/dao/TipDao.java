package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.TipDto;

public class TipDao {
	DataSource dataSource;
	
	public TipDao() {
		try {
			Context context =new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//tip 작성
	public int write(String T_TITLE, String T_CONTENT, String T_IMAGE, String T_CATEGORY, String myEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		int t_num = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into tip(T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, T_TITLE);
			preparedStatement.setString(2, T_CONTENT);
			preparedStatement.setString(3, T_IMAGE);
			preparedStatement.setString(4, T_CATEGORY);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			query = "SELECT LAST_INSERT_ID()";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				t_num = resultset.getInt(1);
				System.out.println("list-count success");
			}
			preparedStatement.close();
			query = "insert into write_tip(user_email, tip_t_num, tw_regist) values(?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, myEmail);
			preparedStatement.setInt(2, t_num);
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
		return t_num;
}

	//tip 불러오기
	public TipDto read(String strT_NUM) {
		TipDto tipDto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from tip where T_NUM = ?"; //select 문에 ?을 쓰는 것은 보안상 쓰는 것이다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strT_NUM));
			resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					int T_NUM = resultSet.getInt("T_NUM"); //숫자 적어도 무관
					String T_TITLE = resultSet.getString("T_TITLE");
					String T_CONTENT = resultSet.getString("T_CONTENT");
					String T_IMAGE = resultSet.getString("T_IMAGE");
					String T_CATEGORY = resultSet.getString("T_CATEGORY");
				
					tipDto = new TipDto(T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY);//return을 하기 위해 밑에 데이터를 사용함
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
		return tipDto;
	}
	
	//tip 수정
	public void update(String strT_NUM, String T_TITLE, String T_CONTENT, String T_IMAGE, String T_CATEGORY) {
		int T_NUM = Integer.parseInt(strT_NUM);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update tip set T_TITLE = ? , T_CONTENT = ? ,T_IMAGE = ?, T_CATEGORY=? where T_NUM = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, T_TITLE);
			preparedStatement.setString(2, T_CONTENT);
			preparedStatement.setString(3, T_IMAGE);
			preparedStatement.setString(4, T_CATEGORY);
			preparedStatement.setInt(5, T_NUM);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			query = "UPDATE write_tip SET TW_EDIT = now() WHERE TIP_T_NUM = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, T_NUM);
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

	
	


}//---------------------
