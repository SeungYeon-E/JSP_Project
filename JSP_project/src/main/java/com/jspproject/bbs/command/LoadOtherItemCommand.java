package com.jspproject.bbs.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ItemsDao;
import com.jspproject.bbs.dto.PostDto;

public class LoadOtherItemCommand implements Command {

	int numOfTuplesPerPage = 15;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		// TODO Auto-generated method stub
		
		ItemsDao dao = new ItemsDao();
		int requestPage = 1;
		session = request.getSession();
		
		
		if ( request.getParameter("page") != null) {
			int posts = (int)session.getAttribute("postsCount");
			requestPage = posts + numOfTuplesPerPage;
			session.setAttribute("postsCount", requestPage);
		}
		
		ArrayList<PostDto> dtos = dao.listOthers(requestPage, numOfTuplesPerPage);
		request.setAttribute("list", dtos);
		session.setAttribute("CATEGORY", "ITEM");
		session.setAttribute("CONDITION", "I_TITLE");
		session.setAttribute("do", "listOthers.do");
	}

}
