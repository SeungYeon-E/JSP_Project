package com.jspproject.bbs.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.command.Command;
import com.jspproject.bbs.dao.ContentItemdao;

public class CommentViewCommend implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String ccNo =request.getParameter("ccNo");
		
		ContentItemdao dao = new ContentItemdao();
		dao.commentContent(ccNo);
		
		request.setAttribute("commentcontent_view", dao);
	}

}
