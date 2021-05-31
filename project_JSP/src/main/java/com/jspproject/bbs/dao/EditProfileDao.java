package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.ProfileDto;

public class EditProfileDao {

	DataSource dataSource;
	
	public EditProfileDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	public ProfileDto loadProfile(String userId) {
		ProfileDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT EMAIL, NAME, ADRESS, TEL, GIT FROM USER WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				String userEmail= resultset.getString("EMAIL");
				String userName= resultset.getString("NAME");
				String userAddress= resultset.getString("ADRESS");
				String phoneNumber = resultset.getString("TEL");
				String userGit= resultset.getString("GIT");
				dto = new ProfileDto(userEmail, userName, phoneNumber, userGit);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void edit(String name, String adress, String tel, String git, String email) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE USER SET NAME = ?, ADRESS = ?, TEL = ?, GIT = ? WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, adress);
			preparedStatement.setString(3, tel);
			preparedStatement.setString(4, git);
			preparedStatement.setString(5, email);
			
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
	
	public void changePassword(String password, String email) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE USER SET PWD = ? WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, password);
			preparedStatement.setString(5, email);
			
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
	
	public void deleteAccount(String password, String email) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE USER SET DELETE = curdate() WHERE EMAIL = ? AND PWD = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
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
