package com.jsplec.bbs.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.bbs.dao.BDao;
import com.jsplec.bbs.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 전체정보 읽어서 attribute로 jsp에 전달하기
		
		BDao dao = new BDao();
		int temppage = dao.selectcnt();
		System.out.println(temppage);
		
		
		String tempStart = request.getParameter("list");
		//int count = Integer.parseInt(request.getParameter("page"));

		int startPage = 0;
		int onePageCnt=9;
		int pagenum = 0;
		
		pagenum = (int)Math.ceil((double)temppage/(double)onePageCnt);
		
		if(tempStart != null){
			startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
		}
		
		ArrayList<BDto> dtos = dao.list(startPage, onePageCnt);
		
		request.setAttribute("list", dtos);
//		request.setAttribute("page", temppage);
		
//		<%
//		BDao dao = new BDao();
//		String tempStart = request.getParameter("list");
//		int count = Integer.parseInt(request.getParameter("page"));
//
//
//		int startPage = 0;
//		int onePageCnt=10;
//		
//		count = (int)Math.ceil((double)count/(double)onePageCnt);
//		
//		if(tempStart != null){
//			startPage = (Integer.parseInt(tempStart)-1)*onePageCnt;
//		}
//		
//		ArrayList<BDto> dtos = dao.list(startPage, onePageCnt);
//
//	%>
		
	}

}
