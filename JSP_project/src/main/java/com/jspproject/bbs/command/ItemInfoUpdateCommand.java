package com.jspproject.bbs.command;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.ItemInfoDao;
import com.jspproject.bbs.filepath.FilePath;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ItemInfoUpdateCommand implements Command {
	
	FilePath  cv = new FilePath();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		MultipartRequest multipartRequest1 = null;
		String I_NUM  = null;
		String I_TITLE  = null;
		String I_CONTENT = null;
		String I_IMAGE = null;
		String I_CATEGORY = null;
		
		// 파일크기 제한 설정 (15mb)
		int sizeLimit1 = 15 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		String realPath1 = context.getRealPath(cv.jsp_project_filepath);
		
		 //위 경로의 디렉토리가 존재하지 않으면 새로 생성 
		File dir1 = new File(realPath1);
		if (!dir1.exists()) {
			try {
				dir1.mkdir(); // 폴더 생성합니다.
				System.out.println("폴더가 생성되었습니다.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		try {
			multipartRequest1 = new MultipartRequest(request, realPath1, sizeLimit1, "utf-8", new DefaultFileRenamePolicy());
	
			I_NUM = multipartRequest1.getParameter("I_NUM");
			I_TITLE = multipartRequest1.getParameter("I_TITLE");
			I_CONTENT = multipartRequest1.getParameter("I_CONTENT");
			I_IMAGE  = multipartRequest1.getParameter("I_IMAGE");
			I_CATEGORY = multipartRequest1.getParameter("I_CATEGORY");
			
			String originalFile = multipartRequest1.getOriginalFileName("I_IMAGE");
			
			ItemInfoDao itemInfoDao = new ItemInfoDao();
			
			//업로드한 파일이 없을시 save/null로 db에 기록되므로, 이를 방지하기 위해 분기
			if(originalFile == null) {
				I_IMAGE = multipartRequest1.getParameter("oldFilePath");
			} else {
				I_IMAGE = "save/" + originalFile;
			}
			
			itemInfoDao.update(I_NUM, I_TITLE, I_CONTENT, I_IMAGE, I_CATEGORY);
			int i_num = Integer.parseInt(I_NUM);
			request.setAttribute("result", i_num);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

	}

}
