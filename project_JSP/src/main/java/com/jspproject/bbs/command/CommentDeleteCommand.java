package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;

public class CommentDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String ccNo =request.getParameter("ccNo");
		ContentItemdao dao = new ContentItemdao();
		String result = dao.commentDelete(ccNo);
		request.setAttribute("result", result);
	}
}
