package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDao;
import com.jsplec.bbs.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId =request.getParameter("bId");
		BDao dao = new BDao();
		
		//클릭된 댓글리스트 불러오기
		ArrayList<BDto> dtos = dao.commentSelect(bId);
		request.setAttribute("comment_view", dtos);
		
		//클릭된 게시물 상세페이지 보여주기
		BDto dto = dao.contentView(bId);
		request.setAttribute("content_view", dto);
		
	}

}
