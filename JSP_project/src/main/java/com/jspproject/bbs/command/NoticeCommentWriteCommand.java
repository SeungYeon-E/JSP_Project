package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentNoticedao;

public class NoticeCommentWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String n_num = request.getParameter("n_num");
		
		String myEmail = (String) session.getAttribute("email");
		String nc_content = request.getParameter("nc_content");
		ContentNoticedao dao = new ContentNoticedao();
		String result = dao.commentWrite(n_num, myEmail, nc_content);

		request.setAttribute("result", result);
	}

}
