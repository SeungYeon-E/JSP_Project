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

			String query = "select * from TIP where t_num in (select tip_t_num from write_tip where tw_delete is null) LIMIT ?, ?";
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

			String query = "SELECT * FROM TIP where T_CATEGORY = '코드' and t_num in (select tip_t_num from write_tip where tw_delete is null) LIMIT ?, ?";
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

			String query = "SELECT * FROM TIP where T_CATEGORY = '프로토타입' and t_num in (select tip_t_num from write_tip where tw_delete is null) ?, ?";
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

			String query = "SELECT * FROM TIP where T_CATEGORY = '정보' and t_num in (select tip_t_num from write_tip where tw_delete is null) LIMIT ?, ?";
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

			String query = "SELECT * FROM TIP where T_CATEGORY = '기타' and t_num in (select tip_t_num from write_tip where tw_delete is null) LIMIT ?, ?";
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
