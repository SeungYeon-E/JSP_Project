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
import com.jspproject.bbs.command.CommentContentCommand;
import com.jspproject.bbs.command.CommentDeleteCommand;
import com.jspproject.bbs.command.CommentModifyCommand;
import com.jspproject.bbs.command.CommentWriteCommand;
import com.jspproject.bbs.command.ContentItemCommand;
import com.jspproject.bbs.command.ContentItemDeleteCommand;
import com.jspproject.bbs.command.ContentNoticeCommand;
import com.jspproject.bbs.command.ContentNoticeDeleteCommand;
import com.jspproject.bbs.command.ContentTipCommand;
import com.jspproject.bbs.command.ContentTipDeleteCommand;
import com.jspproject.bbs.command.NoticeCommentContentCommand;
import com.jspproject.bbs.command.NoticeCommentDeleteCommand;
import com.jspproject.bbs.command.NoticeCommentModifyCommand;
import com.jspproject.bbs.command.NoticeCommentWriteCommand;
import com.jspproject.bbs.command.TipCommentContentCommand;
import com.jspproject.bbs.command.TipCommentDeleteCommand;
import com.jspproject.bbs.command.TipCommentModifyCommand;
import com.jspproject.bbs.command.TipCommentWriteCommand;
import com.jspproject.bbs.command.UserLoginCommand;
import com.jspproject.bbs.command.UserRegisterCommand;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost()");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		String viewPage = null;
		Command command = null;

		switch (com) {

//		<예시> 게시판 리스트 열기  
//		case("/list.do"):
//			command = new ListCommand();
//			command.execute(request, response);
//			viewPage = "List.jsp";
//			break;

		/*
		 * 단순 페이지 이동
		 */
		// 로그인 창으로 이동
		case ("/Home.do"): // 실행시 ~~.do사용
			viewPage = "Home.jsp"; // 실행할 jsp파일
			break;

		// 회원가입 창으로 이동
		case ("/Signup.do"): // 실행시 ~~.do사용
			viewPage = "Signup.jsp"; // 실행할 jsp파일
			break;

		// 이용약관
		case ("/TermsAndConditions.do"): // 실행시 ~~.do사용
			viewPage = "TermsAndConditions.jsp"; // 실행할 jsp파일
			break;

		// 개인정보 처리방침
		case ("/PrivacyPolicy.do"): // 실행시 ~~.do사용
			viewPage = "PrivacyPolicy.jsp"; // 실행할 jsp파일
			break;

		// 이메일 찾기창
		case ("/emailCheckForm.do"): // 실행시 ~~.do사용
			viewPage = "EmailSearch.jsp"; // 실행할 jsp파일
			break;

		// 비밀번호 찾기창
		case ("/PwSearch.do"): // 실행시 ~~.do사용
			viewPage = "PwSearch.jsp"; // 실행할 jsp파일
			break;

		// 메인으로
		case ("/Main.do"): // 실행시 ~~.do사용
			viewPage = "Header.jsp"; // 실행할 jsp파일
			break;

		// 로그인실패
		case ("/LoginFail.do"): // 실행시 ~~.do사용
			viewPage = "LoginFail.jsp"; // 실행할 jsp파일
			break;

		// 로그아웃
		case ("/Logout.do"): // 실행시 ~~.do사용
			// 세션끔
			session.invalidate();
			viewPage = "Home.jsp"; // 실행할 jsp파일
			break;

		/*
		 * 메소드 실행
		 */

		// 회원가입
		case ("/register.do"):
			command = new UserRegisterCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "Home.do";
			break;
		// 로그인 클릭시
		case ("/login.do"):
			command = new UserLoginCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);

			// 세션에 이메일값 저장해서 공백이면 로그인 실패처리시킴 사용엔 문제없지만 사실 이부분 피드백이 필요함...
			if (session.getAttribute("email").equals("")) {
				session.invalidate();
				viewPage = "LoginFail.do";
			} else {
				viewPage = "Main.do";
			}
			break;
		/*
		 * ----------------------------- 
		 * 21.05.21 seungyeon Item 상세페이지 
		 * 현재 userEmail 변수 선언해서 진행중
		 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
		 *   -----------------------------
		 */
		// Item - 상세페이지 불러오기 0517 이승연
		case ("/ContentViewItem.do"): // 실행시 ~~.do사용
			command = new ContentItemCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "ContentViewItem.jsp"; // 실행할 jsp파일
			break;
		// Item - 상세페이지 게시물 삭제하기 0518 이승연
		case ("/ContentViewItemdelete.do"):
			command = new ContentItemDeleteCommand();
			command.execute(request, response, session);
			viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
			break;
		// Item - 상세페이지 댓글입력 0518 이승연
		case ("/CommentWriteItem.do"): // 실행시 ~~.do사용
			command = new CommentWriteCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
			break;
		// Item - 상세페이지 댓글 불러오기 0521 이승연
		case ("/CommentContentItem.do"):
			command = new CommentContentCommand();
			command.execute(request, response, session);
			viewPage = "CommentContentView.jsp"; // 실행할 jsp파일
			break;
		// Item - 상세페이지 댓글 수정하기 0521 이승연
		case ("/CommentModifyItem.do"):
			command = new CommentModifyCommand();
			command.execute(request, response, session);
			viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
			break;
		// Item - 상세페이지 댓글 삭제하기 0521 이승연
		case ("/CommentDeleteItem.do"):
			command = new CommentDeleteCommand();
			command.execute(request, response, session);
			viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
			break;
		/*
		 * ----------------------------- 
		 * 21.05.23 seungyeon tip 상세페이지 
		 * 현재 userEmail 변수 선언해서 진행중
		 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
		 *   -----------------------------
		 */	
		// tip - 상세페이지 불러오기 0523 이승연
		case ("/ContentViewTip.do"): // 실행시 ~~.do사용
			command = new ContentTipCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "ContentViewTip.jsp"; // 실행할 jsp파일
			break;
		// tip - 상세페이지 게시물 삭제하기 0518 이승연
		case ("/ContentViewTipdelete.do"):
			command = new ContentTipDeleteCommand();
			command.execute(request, response, session);
			viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
			break;
		// tip - 상세페이지 댓글입력 0518 이승연
		case ("/TipCommentWrite.do"): // 실행시 ~~.do사용
			command = new TipCommentWriteCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
			break;
		// tip - 상세페이지 댓글 불러오기 0521 이승연
		case ("/TipCommentContent.do"):
			command = new TipCommentContentCommand();
			command.execute(request, response, session);
			viewPage = "TipCommentContentView.jsp"; // 실행할 jsp파일
			break;
		// tip - 상세페이지 댓글 수정하기 0521 이승연
		case ("/TipCommentModify.do"):
			command = new TipCommentModifyCommand();
			command.execute(request, response, session);
			viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
			break;
		// tip - 상세페이지 댓글 삭제하기 0521 이승연
		case ("/TipCommentDelete.do"):
			command = new TipCommentDeleteCommand();
			command.execute(request, response, session);
			viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
			break;
		/*
		 * ----------------------------- 
		 * 21.05.23 seungyeon notice 상세페이지 
		 * 현재 userEmail 변수 선언해서 진행중
		 *  -> 상세페이지 게시물 삭제하기 list로 돌아가기 변경해야함
		 *   -----------------------------
		 */	
		// notice - 상세페이지 불러오기 0523 이승연
		case ("/ContentViewNotice.do"): // 실행시 ~~.do사용
			command = new ContentNoticeCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "ContentViewNotice.jsp"; // 실행할 jsp파일
			break;
		// notice - 상세페이지 게시물 삭제하기 0518 이승연
		case ("/ContentViewNoticedelete.do"):
			command = new ContentNoticeDeleteCommand();
			command.execute(request, response, session);
			viewPage = "ContentDeleteView.jsp"; // 실행할 jsp파일
			break;
		// notice - 상세페이지 댓글입력 0518 이승연
		case ("/NoticeCommentWrite.do"): // 실행시 ~~.do사용
			command = new NoticeCommentWriteCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "CommentWriteView.jsp"; // 실행할 jsp파일
			break;
		// notice - 상세페이지 댓글 불러오기 0521 이승연
		case ("/NoticeCommentContent.do"):
			command = new NoticeCommentContentCommand();
			command.execute(request, response, session);
			viewPage = "NoticeCommentContentView.jsp"; // 실행할 jsp파일
			break;
		// notice - 상세페이지 댓글 수정하기 0521 이승연
		case ("/NoticeCommentModify.do"):
			command = new NoticeCommentModifyCommand();
			command.execute(request, response, session);
			viewPage = "CommentModifyView.jsp"; // 실행할 jsp파일
			break;
		// notice - 상세페이지 댓글 삭제하기 0521 이승연
		case ("/NoticeCommentDelete.do"):
			command = new NoticeCommentDeleteCommand();
			command.execute(request, response, session);
			viewPage = "CommentDeleteView.jsp"; // 실행할 jsp파일
			break;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}// ---------------
