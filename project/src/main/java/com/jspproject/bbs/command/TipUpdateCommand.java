package com.jspproject.bbs.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.dao.TipDao;
import com.jspproject.bbs.filepath.FilePath;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class TipUpdateCommand implements Command {

	FilePath  cv = new FilePath();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		MultipartRequest multipartRequest1 = null;
		String T_NUM  = null;
		String T_TITLE  = null;
		String T_CONTENT = null;
		String T_IMAGE = null;
		String T_CATEGORY = null;
		
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
	
			T_NUM = multipartRequest1.getParameter("T_NUM");
			T_TITLE = multipartRequest1.getParameter("T_TITLE");
			T_CONTENT = multipartRequest1.getParameter("T_CONTENT");
			T_IMAGE  = multipartRequest1.getParameter("T_IMAGE");
			T_CATEGORY = multipartRequest1.getParameter("T_CATEGORY");
			
			String originalFile = multipartRequest1.getOriginalFileName("T_IMAGE");
			
			TipDao tipDao = new TipDao();
			
			//업로드한 파일이 없을시 save/null로 db에 기록되므로, 이를 방지하기 위해 분기
			if(originalFile == null) {
				T_IMAGE = multipartRequest1.getParameter("oldFilePath");
			} else {
				T_IMAGE = "save_t/" + originalFile;
			}
			
			tipDao.update(T_NUM, T_TITLE, T_CONTENT, T_IMAGE, T_CATEGORY);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} 




	}
}
