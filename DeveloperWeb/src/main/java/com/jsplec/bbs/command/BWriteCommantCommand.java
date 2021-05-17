package com.jsplec.bbs.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDao;
import com.jsplec.bbs.dto.BDto;

public class BWriteCommantCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		String userid = request.getParameter("userid");
		String cContent = request.getParameter("cContent");
		
		BDao dao = new BDao();
		dao.commentwrite(bId, userid, cContent);
	}

}
