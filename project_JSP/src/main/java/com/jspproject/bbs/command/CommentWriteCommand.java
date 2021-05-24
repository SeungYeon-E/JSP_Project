package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;

public class CommentWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String i_num = request.getParameter("i_num");
		String myEmail = (String) session.getAttribute("email");
		String ic_content = request.getParameter("ic_content");
		ContentItemdao dao = new ContentItemdao();
		String result = dao.commentWrite(i_num, myEmail, ic_content);

		request.setAttribute("result", result);
		
	}
	
}
