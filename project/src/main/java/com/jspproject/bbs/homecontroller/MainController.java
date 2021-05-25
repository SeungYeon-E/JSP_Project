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
import com.jspproject.bbs.command.ItemInfoContentCommand;
import com.jspproject.bbs.command.ItemInfoInsertCommand;
import com.jspproject.bbs.command.ItemInfoUpdateCommand;
import com.jspproject.bbs.command.NoticeContentCommand;
import com.jspproject.bbs.command.NoticeInsertCommand;
import com.jspproject.bbs.command.NoticeUpdateCommand;
import com.jspproject.bbs.command.TipContentCommand;
import com.jspproject.bbs.command.TipInsertCommand;
import com.jspproject.bbs.command.TipUpdateCommand;


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
		
		System.out.println("actionDo()");
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
	
		/*
		 * 단순 페이지 이동
		 */
		//로그인 창으로 이동
		/*
		 * case("/Home.do"): // 실행시 ~~.do사용 viewPage = "Home.jsp"; // 실행할 jsp파일 break;
		 * 
		 * //회원가입 창으로 이동 case("/Signup.do"): // 실행시 ~~.do사용 viewPage = "Signup.jsp"; //
		 * 실행할 jsp파일 break;
		 * 
		 * //이용약관 case("/TermsAndConditions.do"): // 실행시 ~~.do사용 viewPage =
		 * "TermsAndConditions.jsp"; // 실행할 jsp파일 break;
		 * 
		 * //개인정보 처리방침 case("/PrivacyPolicy.do"): // 실행시 ~~.do사용 viewPage =
		 * "PrivacyPolicy.jsp"; // 실행할 jsp파일 break;
		 * 
		 * //이메일 찾기창으로 case("/EmailCheckForm.do"): // 실행시 ~~.do사용 viewPage =
		 * "EmailSearch.jsp"; // 실행할 jsp파일 break;
		 * 
		 * //비밀번호 찾기창으로 case("/PwdCheckForm.do"): // 실행시 ~~.do사용 viewPage =
		 * "PwdSearch.jsp"; // 실행할 jsp파일 break;
		 * 
		 * //메인으로 case("/Main.do"): // 실행시 ~~.do사용 viewPage = "Header.jsp"; // 실행할 jsp파일
		 * break;
		 * 
		 * //로그아웃 case("/Logout.do"): // 실행시 ~~.do사용 //세션끔 session.invalidate();
		 * viewPage = "Home.jsp"; // 실행할 jsp파일 break;
		 * 
		 * case("/naver.do"): // 실행시 ~~.do사용 viewPage = "naverCallback.jsp"; // 실행할
		 * jsp파일 break;
		 * 
		 */
			
		/*
		 * 메소드 실행
		 */
		//Tip 작성 및 수정
		
		//Tip 글 폼
		case("/TipViewBoard.do"): 	
		viewPage = "TipView.jsp";
		break;

			//Tip 글 작성하기
		case("/TipInsertBoard.do"): 
			command = new TipInsertCommand();
			command.execute(request, response, session);	
			viewPage = "TipView.jsp";
			break;
			
			//Item 글 불러오기
		case("/TipContentBoard.do"): 
			command = new TipContentCommand();
			command.execute(request, response, session);	
			viewPage = "TipUpdateBoard.jsp";
		break;

			
			//Tip 글 수정하기
		case("/TipUpdateBoard.do"): 
			command = new TipUpdateCommand();
			command.execute(request, response, session);	
			viewPage = "TipUpdateBoard.jsp";
		break;
		
		//Item 작성 및 수정
	
			//Item 글 폼
		case("/ItemInfoView.do"): 	
			viewPage = "ItemInfoView.jsp"; 
			break;
			
			//Item 글 작성하기
		case("/ItemInfoInsert.do"): 
			command = new ItemInfoInsertCommand();
			command.execute(request, response, session);	
			viewPage = "ItemInfoView.jsp"; //내가 작성한 글 번호 가져와서 상세 페이지로 갔으면 좋겠음.
			break;
			
			//Item 글 불러오기
		case("/ItemInfoContent.do"): 
			command = new ItemInfoContentCommand();
			command.execute(request, response, session);	
			viewPage = "ItemInfoUpdate.jsp";
		break;
		
			//Item 글 수정하기
		case("/ItemInfoUpdate.do"): 
			command = new ItemInfoUpdateCommand();
			command.execute(request, response, session);	
			viewPage = "ItemInfoUpdate.jsp"; // 글 수정할 때, 번호를 받아서 정보를 받고 상세페이지로 갔으면 좋겠음.
		break;
		
		
		//notice 작성 및 수정
		
		//notice 글 폼
		case("/NoticeView.do"): 	
			viewPage = "NoticeView.jsp";
		break;
		
		//notice 글 작성하기
		case("/NoticeInsert.do"): 
			command = new NoticeInsertCommand();
			command.execute(request, response, session);	
			viewPage = "NoticeView.jsp";
		break;
		
		//notice 글 불러오기
		case("/NoticeContent.do"): 
			command = new NoticeContentCommand();
			command.execute(request, response, session);	
			viewPage = "NoticeUpdate.jsp";
		break;
		
		//notice 글 수정하기
		case("/NoticeUpdate.do"): 
			command = new NoticeUpdateCommand();
			command.execute(request, response, session);	
			viewPage = "NoticeUpdate.jsp";
		break;
	
	}	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}//---------------
