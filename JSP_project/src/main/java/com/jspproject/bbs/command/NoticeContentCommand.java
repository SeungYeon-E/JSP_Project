package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.NoticeDao;
import com.jspproject.bbs.dto.NoticeDto;



public class NoticeContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String N_NUM =request.getParameter("n_num");
		NoticeDao noticeDao = new NoticeDao();
		NoticeDto noticeDto = noticeDao.read(N_NUM);
		request.setAttribute("read", noticeDto);

	}

}
