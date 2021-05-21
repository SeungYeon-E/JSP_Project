package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;


public class CommentModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String ccNo =request.getParameter("ccNo");
		String cContent = request.getParameter("cContent");
		
		ContentItemdao dao = new ContentItemdao();
		dao.commentModiey(ccNo, cContent);
		
	}

}
