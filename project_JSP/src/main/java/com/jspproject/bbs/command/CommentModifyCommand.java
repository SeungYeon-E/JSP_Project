package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;


public class CommentModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String bId =request.getParameter("bId");
		String bContent = request.getParameter("bContent");
		
		ContentItemdao dao = new ContentItemdao();
		dao.commentModiey(bId, bContent);
		
	}

}
