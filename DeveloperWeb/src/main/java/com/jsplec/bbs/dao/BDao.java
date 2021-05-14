package com.jsplec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.bbs.dto.BDto;



public class BDao {
	DataSource dataSource;
	DataSource dataSource1;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			Context context1 = new InitialContext();
			dataSource1 = (DataSource) context1.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//사용자가 요청한 페이지(offset)와 페이지당 표시할 게시글의 수(limit)을 매개변수로 받는다.
	public ArrayList<BDto> list(int start, int pageCnt){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		// LIMIT {OFFSET}, {LIMIT} -> 쿼리결과중 offset번째부터 limit개의 튜플을 출력  
		String query = "SELECT * FROM mvc_board ORDER BY bId DESC LIMIT ?, ?";
		//page는 1부터 시작하지만, offset은 0부터 시작.(0~9(10개), 10~19(10개)와같이 offset을 설정해야 하기 때문)
		int offset = start - 1;
				
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			// 0을 나누면 에러가 발생하므로 예외처
			if (offset  == 0) {
				preparedStatement.setInt(1, offset);
			} else {
				preparedStatement.setInt(1, offset*pageCnt);
			}
			preparedStatement.setInt(2, pageCnt);
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int bId = resultset.getInt("bId");
				String bName = resultset.getString("bName");
				String bTitle = resultset.getString("bTitle");
				String bContent = resultset.getString("bContent");
				Timestamp bDate = resultset.getTimestamp("bDate");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
				dtos.add(dto);
				System.out.println("list-data load success");
				
			}
			
		}catch(Exception e) {
			System.out.println("list-data load fail");
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("< rs, psmt, conn close success>");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("< rs, psmt, conn close Fail>");
				
			}
		}
		return dtos;
		
	}
	
	public void write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
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
	
	public BDto contentView(String strID) {
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			System.out.println(dataSource1);
			connection = dataSource1.getConnection();
			
			String query = "select * from\n"
						+ "post p, pwrite w\n"
						+ "where p.pNo = w.post_pNo\n"
						+ "and p.pNo = "+ strID+"\n"
						+ ";";

			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultset = preparedStatement.executeQuery();

			System.out.println(resultset);
			if(resultset.next()) {
				int pNo = resultset.getInt("pNo");
				String userEmail = resultset.getString("user_email");
				String pTitle = resultset.getString("pTitle");
				String pContent = resultset.getString("pContent");
				String pImg = resultset.getString("pImg");
				//굳이 이미지 가져ㅗㅇㄹ 피료가 옶오
				String pCategory = resultset.getString("pCategory");
				int pHits = resultset.getInt("pHits");
				int pLike = resultset.getInt("pLike");
				Timestamp wRegistDate = resultset.getTimestamp("wRegistDate");
				
				pContent = content(pContent, pImg);
				System.out.println(pContent);
				dto = new BDto(pNo, userEmail, pTitle, pContent, pImg, pCategory, pHits, pLike, wRegistDate);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		return dto;
	}
	
	public String content(String content, String img) {
		
		String[] arr_img = img.split(",");
//		오늘 소개할 물건은\n<img_id=macBook.png>\n<img_id=macBook2.png>\n입니다.
//		오늘 소개할 물건은\n<img_src=\"http://localhost:8080/DeveloperWeb/img/macBook.png>\n<img_id=macBook2.png\">\n입니다.
		content = content.replaceAll("img_id=", "img src=\"http://localhost:8080/DeveloperWeb/img/");
		content = content.replaceAll("png", "png\"");
		content = content.replaceAll("jpg", "jpg\"");
		
		
		return content;
	}
	
	
	public void delete(String strID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from mvc_board where bId = ?";
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
	
	public void modiey(String bId, String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setString(4, bId);
			
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
	//list에서 사용하는 릴레이션이 가진 튜플의 총 갯수를 리턴한다.
	public int selectcnt(){
		int count=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select count(*) from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				count = resultset.getInt(1);
				System.out.println("list-count success");
			}
			
		}catch(Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		}finally {
			try {
				//정리 다시 거꾸로 정리해주는것
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("< rs, psmt, conn close success>");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("< rs, psmt, conn close Fail>");
				
			}
		}
		return count;
	}
	
	
	
	
	
	
}
