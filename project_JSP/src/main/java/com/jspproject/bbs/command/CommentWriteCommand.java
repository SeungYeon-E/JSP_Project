package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;

public class CommentWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String bId = request.getParameter("bId");
		
		/* 
	 	-----------------------------
	 	21.05.21 seungyeon
	 	****현재 userEmail 변수 선언해서 진행중
	 	-> 추후 세션으로 받아와서 바꿀 것.
	 	-----------------------------
		 */
		
//		String userEmail = (String) session.getAttribute("email");
		String userEmail = "aaa@naver.com";
		
		String ccomment = request.getParameter("ccomment");
		
		ContentItemdao dao = new ContentItemdao();
		dao.commentWrite(bId, userEmail, ccomment);
		
	}
	
}
