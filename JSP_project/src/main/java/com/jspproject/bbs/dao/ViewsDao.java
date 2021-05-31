package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ViewsDao {
	DataSource dataSource;
	
	public ViewsDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public void countingItemView(int num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update item set i_hits = i_hits + 1 where i_num = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, num);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}

	}
	public void countingTipView(int num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update tip set t_hits = t_hits + 1 where t_num = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, num);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	public void countingNoticeView(int num) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update NOTICE set n_hits = n_hits + 1 where n_num = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, num);
			
			preparedStatement.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
	}
}
