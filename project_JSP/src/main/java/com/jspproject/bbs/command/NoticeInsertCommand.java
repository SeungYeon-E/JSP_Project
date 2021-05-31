package com.jspproject.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.NoticeDao;

public class NoticeInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String N_TITLE = request.getParameter("N_TITLE");
		String N_CONTENT = request.getParameter("N_CONTENT");
		String myEmail = (String) session.getAttribute("email");

		NoticeDao NoticeDao = new NoticeDao();
		int n_num = NoticeDao.write(N_TITLE, N_CONTENT,myEmail);
		request.setAttribute("result", n_num);

	}

}
