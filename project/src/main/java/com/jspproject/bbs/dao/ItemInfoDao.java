package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ItemInfoDto;

public class ItemInfoDao {
	
	DataSource dataSource;
	
	public ItemInfoDao() {
		try {
			Context context =new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//item 작성
	public void write(String I_TITLE, String I_CONTENT, String I_IMAGE, String I_CATEGORY, String myEmail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		int i_num = 0;
		try {
			connection = dataSource.getConnection();
			String query = "insert into item(I_TITLE, I_CONTENT, I_IMAGE, I_CATEGORY) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, I_TITLE);
			preparedStatement.setString(2, I_CONTENT);
			preparedStatement.setString(3, I_IMAGE);
			preparedStatement.setString(4, I_CATEGORY);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			query = "SELECT LAST_INSERT_ID()";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				i_num = resultset.getInt(1);
			}
			preparedStatement.close();
			query = "insert into write_item(user_email, item_i_num, iw_regist) values(?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, myEmail);
			preparedStatement.setInt(2, i_num);
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

	
	//item 쓴 것 읽기
	public ItemInfoDto read(String strI_NUM) {
		ItemInfoDto itemInfoDto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from item where I_NUM = ?"; //select 문에 ?을 쓰는 것은 보안상 쓰는 것이다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strI_NUM));
			resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					int I_NUM = resultSet.getInt("I_NUM"); //숫자 적어도 무관
					String I_TITLE = resultSet.getString("I_TITLE");
					String I_CONTENT = resultSet.getString("I_CONTENT");
					String I_IMAGE = resultSet.getString("I_IMAGE");
					String I_CATEGORY = resultSet.getString("I_CATEGORY");
				
				itemInfoDto = new ItemInfoDto(I_NUM, I_TITLE, I_CONTENT, I_IMAGE, I_CATEGORY);//return을 하기 위해 밑에 데이터를 사용함
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
		return itemInfoDto;
	}
	
	

	//item 수정
	public void update(String strI_NUM, String I_TITLE, String I_CONTENT, String I_IMAGE,String I_CATEGORY) {
		int I_NUM = Integer.parseInt(strI_NUM);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update item set I_TITLE = ? , I_CONTENT = ? , I_IMAGE = ?, I_CATEGORY = ? where I_NUM = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, I_TITLE);
			preparedStatement.setString(2, I_CONTENT);
			preparedStatement.setString(3, I_IMAGE);
			preparedStatement.setString(4, I_CATEGORY);
			preparedStatement.setInt(5, I_NUM);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			query = "UPDATE write_item SET IW_EDIT = now() WHERE ITEM_I_NUM = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, I_NUM);
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
