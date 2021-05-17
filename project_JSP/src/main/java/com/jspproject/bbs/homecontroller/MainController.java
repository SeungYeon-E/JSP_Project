package com.jspproject.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.command.Command;
import com.jspproject.bbs.command.ContentItemCommand;


/**
 * Servlet implementation class MainController
 */
@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost()");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		Command command = null;
		
		switch(com) {
		
//		<예시> 게시판 리스트 열기  
//		case("/list.do"):
//			command = new ListCommand();
//			command.execute(request, response);
//			viewPage = "List.jsp";
//			break;
		
		//홈(로그인) 
		case("/Login.do"):
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = "Login.jsp";
			break;
		
		//메인페이지 - 목록보기
		case("/main.do"): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response, session);
			viewPage = "Main.jsp"; // 실행할 jsp파일
			break;

		//Item - list
		case("/ListItem.do"): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = "ListItem.jsp"; // 실행할 jsp파일
			break;
		
		//Item - view 0517 이승연
		case("/ContentViewItem.do"): // 실행시 ~~.do사용
			command = new ContentItemCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "ContentViewItem.jsp"; // 실행할 jsp파일
			break;
		
		//Item - upload
		case("/"): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = ".jsp"; // 실행할 jsp파일
			break;
		
		//Tip - list
		case("/ListTip.do"): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = "ListTip.jsp"; // 실행할 jsp파일
			break;
		
		//Tip - view
		case("/ContentViewTip.jsp.do"): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = "ContentViewTip.jsp"; // 실행할 jsp파일
			break;
		
		//Tip - upload
		case(""): // 실행시 ~~.do사용
//			command = new (); // 커맨드(메소드)적기
//			command.execute(request, response);
			viewPage = ".jsp"; // 실행할 jsp파일
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}//---------------
