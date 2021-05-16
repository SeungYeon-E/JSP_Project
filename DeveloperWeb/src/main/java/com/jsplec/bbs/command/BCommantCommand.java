package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDao;
import com.jsplec.bbs.dto.BDto;

public class BCommantCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId =request.getParameter("bId");
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.commentSelect(bId);
		
		request.setAttribute("comment_view", dtos);
	}

}
