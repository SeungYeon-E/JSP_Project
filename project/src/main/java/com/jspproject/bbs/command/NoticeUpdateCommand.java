package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.NoticeDao;

public class NoticeUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String N_NUM = request.getParameter("N_NUM");
		String N_TITLE = request.getParameter("N_TITLE");
		String N_CONTENT = request.getParameter("N_CONTENT");

		NoticeDao NoticeDao = new NoticeDao();
		NoticeDao.update(N_NUM, N_TITLE, N_CONTENT);

	}

}
