package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.AdminUserdao;

public class AdminUserDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String user_email =request.getParameter("user_email");
		AdminUserdao dao = new AdminUserdao();
		String result = dao.userDelete(user_email);
		request.setAttribute("result", result);
	}

}
