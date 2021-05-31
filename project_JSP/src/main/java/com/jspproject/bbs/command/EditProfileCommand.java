package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.EditProfileDao;

public class EditProfileCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("myName");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address = address1 + " " + address2;
		String tel  = request.getParameter("myNumber");
		String git  = request.getParameter("myGit");
		String email  = (String)session.getAttribute("email");
		
		EditProfileDao dao = new EditProfileDao();
		dao.edit(name, address, tel, git, email);
		
	}

}
