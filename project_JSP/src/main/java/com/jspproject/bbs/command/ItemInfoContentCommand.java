package com.jspproject.bbs.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ItemInfoDao;
import com.jspproject.bbs.dto.ItemInfoDto;
import com.jspproject.bbs.filepath.FilePath;

public class ItemInfoContentCommand implements Command {
	
	FilePath  cv = new FilePath();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		
		String I_NUM =request.getParameter("I_NUM");
		ItemInfoDao itemInfodao = new ItemInfoDao();
		ItemInfoDto itemInfodto = itemInfodao.read(I_NUM);
		
		//파일이 업로드되있는 상태라면 (이름+경로) - 경로를 해서 파일 이름만 추출해서 request로 전송
		if(itemInfodto.getI_image() != null) {
			String filePath = itemInfodto.getI_image();
			String fileName = filePath.substring(cv.jsp_project_filepath.length() + 1);
			request.setAttribute("fileName", fileName);
		}
		request.setAttribute("read", itemInfodto);

	}

}
