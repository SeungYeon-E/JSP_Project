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
		String userEmail = request.getParameter("userEmail");
		String ccomment = request.getParameter("ccomment");
		
		ContentItemdao dao = new ContentItemdao();
		dao.commentWrite(bId, userEmail, ccomment);

	}

}
