package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.TipsDao;
import com.jspproject.bbs.dto.PostDto;


public class LoadTipsCommand implements Command {
	int numOfTuplesPerPage = 15;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		TipsDao dao = new TipsDao();
		int requestPage = 1;
		session = request.getSession();
		
		if ( request.getParameter("page") != null) {
			int posts = (int)session.getAttribute("postsCount");
			requestPage = posts + numOfTuplesPerPage;
			session.setAttribute("postsCount", requestPage);
		}
		
		ArrayList<PostDto> dtos = dao.list(requestPage, numOfTuplesPerPage);
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "TIP");
		session.setAttribute("TITLE", "T_TITLE");
		session.setAttribute("do", "lsit2.do");
	}
}
