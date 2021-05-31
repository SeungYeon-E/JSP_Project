package com.jspproject.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jspproject.bbs.dto.PostDto;


public class TipsDao {
	DataSource dataSource;
	
	public TipsDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public ArrayList<PostDto> list(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY, T_HITS FROM TIP LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			int offset = start - 1;
			
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("T_NUM");
				String title = resultset.getString("T_TITLE");
				String content = resultset.getString("T_CONTENT");
				String imgSrc = resultset.getString("T_IMAGE");
				String category = resultset.getString("T_CATEGORY");
				int views = resultset.getInt("T_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
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
		return dtos;
	}
	
	public ArrayList<PostDto> listCode(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY, T_HITS T_CATEGORY = '코드' FROM TIP LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			int offset = start - 1;
			
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("T_NUM");
				String title = resultset.getString("T_TITLE");
				String content = resultset.getString("T_CONTENT");
				String imgSrc = resultset.getString("T_IMAGE");
				String category = resultset.getString("T_CATEGORY");
				int views = resultset.getInt("T_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
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
		return dtos;
	}
	
	public ArrayList<PostDto> listProto(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY, T_HITS T_CATEGORY = '프로토타입' FROM TIP LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			int offset = start - 1;
			
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("T_NUM");
				String title = resultset.getString("T_TITLE");
				String content = resultset.getString("T_CONTENT");
				String imgSrc = resultset.getString("T_IMAGE");
				String category = resultset.getString("T_CATEGORY");
				int views = resultset.getInt("T_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
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
		return dtos;
	}
	
	public ArrayList<PostDto> listInfo(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY, T_HITS T_CATEGORY = '정보' FROM TIP LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			int offset = start - 1;
			
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("T_NUM");
				String title = resultset.getString("T_TITLE");
				String content = resultset.getString("T_CONTENT");
				String imgSrc = resultset.getString("T_IMAGE");
				String category = resultset.getString("T_CATEGORY");
				int views = resultset.getInt("T_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
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
		return dtos;
	}
	
	public ArrayList<PostDto> listOther(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			connection = dataSource.getConnection();

			String query = "SELECT T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY, T_HITS T_CATEGORY = '기타' FROM TIP LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			int offset = start - 1;
			
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();

			while(resultset.next()) {
				int num = resultset.getInt("T_NUM");
				String title = resultset.getString("T_TITLE");
				String content = resultset.getString("T_CONTENT");
				String imgSrc = resultset.getString("T_IMAGE");
				String category = resultset.getString("T_CATEGORY");
				int views = resultset.getInt("T_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
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
		return dtos;
	}
}
