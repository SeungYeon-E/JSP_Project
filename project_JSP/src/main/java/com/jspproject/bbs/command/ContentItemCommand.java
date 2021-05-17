package com.jspproject.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ContentItemdao;
import com.jspproject.bbs.dto.ContentItemdto;


public class ContentItemCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String bId =request.getParameter("bId");
		ContentItemdao dao = new ContentItemdao();
		
		//클릭된 댓글리스트 불러오기
		ArrayList<ContentItemdto> dtos = dao.commentSelect(bId);
		request.setAttribute("comment_view", dtos);
		
		//클릭된 게시물 상세페이지 보여주기
		ContentItemdto dto = dao.contentView(bId);
		request.setAttribute("content_view", dto);
		
	}

}
