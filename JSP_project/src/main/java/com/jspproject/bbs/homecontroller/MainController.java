package com.jspproject.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspproject.bbs.command.AdminUserDeleteCommand;
import com.jspproject.bbs.command.AdminUserRecoverCommand;
import com.jspproject.bbs.command.AdminUserlistCommand;
import com.jspproject.bbs.command.AdminuserSearchCommand;
import com.jspproject.bbs.command.ChangePasswordCommand;
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
import com.jspproject.bbs.command.DeleteAccountCommand;
import com.jspproject.bbs.command.DonateCommand;
import com.jspproject.bbs.command.DonateSumCommand;
import com.jspproject.bbs.command.EditProfileCommand;
import com.jspproject.bbs.command.EditProfileViewCommand;
import com.jspproject.bbs.command.ItemInfoContentCommand;
import com.jspproject.bbs.command.ItemInfoInsertCommand;
import com.jspproject.bbs.command.ItemInfoUpdateCommand;
import com.jspproject.bbs.command.LoadAccItemCommand;
import com.jspproject.bbs.command.LoadCodeTipCommand;
import com.jspproject.bbs.command.LoadComItemCommand;
import com.jspproject.bbs.command.LoadDeskItemCommand;
import com.jspproject.bbs.command.LoadInfoTipCommand;
import com.jspproject.bbs.command.LoadItemsCommand;
import com.jspproject.bbs.command.LoadMyAllCommand;
import com.jspproject.bbs.command.LoadMyItemCommand;
import com.jspproject.bbs.command.LoadMyTipCommand;
import com.jspproject.bbs.command.LoadNoticeCommand;
import com.jspproject.bbs.command.LoadOtherItemCommand;
import com.jspproject.bbs.command.LoadOtherTipCommand;
import com.jspproject.bbs.command.LoadProtoTipCommand;
import com.jspproject.bbs.command.LoadTipsCommand;
import com.jspproject.bbs.command.LoadUserInfo;
import com.jspproject.bbs.command.LoadUsersItem;
import com.jspproject.bbs.command.LoadUsersTip;
import com.jspproject.bbs.command.NoticeCommentContentCommand;
import com.jspproject.bbs.command.NoticeCommentDeleteCommand;
import com.jspproject.bbs.command.NoticeCommentModifyCommand;
import com.jspproject.bbs.command.NoticeCommentWriteCommand;
import com.jspproject.bbs.command.NoticeContentCommand;
import com.jspproject.bbs.command.NoticeInsertCommand;
import com.jspproject.bbs.command.NoticeUpdateCommand;
import com.jspproject.bbs.command.SearchingCommand;
import com.jspproject.bbs.command.TipCommentContentCommand;
import com.jspproject.bbs.command.TipCommentDeleteCommand;
import com.jspproject.bbs.command.TipCommentModifyCommand;
import com.jspproject.bbs.command.TipCommentWriteCommand;
import com.jspproject.bbs.command.TipContentCommand;
import com.jspproject.bbs.command.TipInsertCommand;
import com.jspproject.bbs.command.TipUpdateCommand;
import com.jspproject.bbs.command.UserEmailSearchCommand;
import com.jspproject.bbs.command.UserLoginCommand;
import com.jspproject.bbs.command.UserPwdSearchCommand;
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
		
		/*
		 * ------------------------------------
		 * 김도우
		 * 
		 * 단순 페이지 이동
		 */
		
		//로그인 창으로 이동
		case("/Login.do"): // 실행시 ~~.do사용
			viewPage = "Login.jsp"; // 실행할 jsp파일
		break;
		
		//회원가입 창으로 이동 
		case("/Signup.do"): // 실행시 ~~.do사용
			viewPage = "Signup.jsp"; // 실행할 jsp파일
			break;
		
		//이용약관
		case("/TermsAndConditions.do"): // 실행시 ~~.do사용
			viewPage = "TermsAndConditions.jsp"; // 실행할 jsp파일
		break;
		
		//개인정보 처리방침
		case("/PrivacyPolicy.do"): // 실행시 ~~.do사용
			viewPage = "PrivacyPolicy.jsp"; // 실행할 jsp파일
		break;
		
		//이메일 찾기창으로
		case("/EmailCheckForm.do"): // 실행시 ~~.do사용
			viewPage = "EmailSearch.jsp"; // 실행할 jsp파일
		break;
		
		//비밀번호 찾기창으로
		case("/PwdCheckForm.do"): // 실행시 ~~.do사용
			viewPage = "PwdSearch.jsp"; // 실행할 jsp파일
		break;
		
		//메인으로
		case("/Main.do"): // 실행시 ~~.do사용
			session.setAttribute("postsCount", 1);
			viewPage = "Main.jsp";
		break;
		
		//로그아웃
		case("/Logout.do"): // 실행시 ~~.do사용
			//세션끔
			session.invalidate();
			viewPage = "Login.jsp"; // 실행할 jsp파일
		break;
		
		//네이버로그인시 콜백
		case("/naver.do"): // 실행시 ~~.do사용
			viewPage = "naverCallback.jsp"; // 실행할 jsp파일
		break;
	
		
		/*
		 * 메소드 실행
		 */
		
		//회원가입
		case("/register.do"):
			command = new UserRegisterCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "SignupSuccess.jsp";
			break;
		//로그인 클릭시	
		case("/loginClick.do"):
			command = new UserLoginCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			//세션에 이메일값 저장해서 공백이면 로그인 실패처리시킴 사용엔 문제없지만 사실 이부분 피드백이 필요함...
			if(session.getAttribute("email").equals("")) {
				session.invalidate();
				viewPage = "LoginFail.jsp"; //정보 불일치 실패시
			}else if
			(session.getAttribute("deletedate")==null) {
				viewPage = "Main.jsp"; //성공시		
			}else {
				session.invalidate();
				viewPage = "LoginWithdraw.jsp"; //탈퇴회원	
			}
			break;
		
		//이메일 중복체크
		case("/EmailCheck.do"):
		command = new UserEmailSearchCommand(); // 커맨드(메소드)적기
		command.execute(request, response, session);
		viewPage = "Signup.do";
		break;
		
		//이메일 찾기 버튼 클릭 후
		case("/EmailSearch.do"):
			command = new UserEmailSearchCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			if(session.getAttribute("searchEmail").equals("")) {
				session.invalidate();
				viewPage = "EmailSearchFail.jsp"; //실패시
			
			}else if(session.getAttribute("searchDeletedate")==null) {
				viewPage = "EmailSearchSuccess.jsp"; //성공시	
			
			}else {
				viewPage = "EmailSearchWithdraw.jsp"; //탈퇴회원	
			}

			break;
		
		//패스워드 찾기 버튼 클릭 후
		case("/PwdSearch.do"):
			command = new UserPwdSearchCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			
			if(session.getAttribute("searchPwd").equals("")) {
				session.invalidate();
				viewPage = "PwdSearchFail.jsp"; //실패시
			}else if(session.getAttribute("searchDeletedate")==null) {
				viewPage = "PwdSearchSuccess.jsp"; //성공시
			}else {
				session.invalidate();
				viewPage = "PwdSearchWithdraw.jsp"; //탈퇴회원
			}
			
			break;
			
		//기부
		case("/Donation.do"): // 실행시 ~~.do사용
			command = new DonateSumCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "Donation.jsp"; // 실행할 jsp파일
		break;
		
		//기부버튼 클릭시
		case("/DonateClick.do"): // 실행시 ~~.do사용
			command = new DonateCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "DonationSuccess.jsp"; // 실행할 jsp파일
			break;

			//----------------------------------------김도우
	
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
			/*
			 * ----------------------------- 
			 * 21.05.24 seungyeon adminuser 상세페이지 
			 *   -----------------------------
			 */	
			// adminuser - list 불러오기 0523 이승연
			case ("/AdminUserlist.do"): // 실행시 ~~.do사용
				command = new AdminUserlistCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "AdminUserList.jsp"; // 실행할 jsp파일
				break;
			case ("/AdminUserDelete.do"): // 실행시 ~~.do사용
				command = new AdminUserDeleteCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "AdminUserDeleteView.jsp"; // 실행할 jsp파일
				break;
			case ("/AdminUserRecover.do"): // 실행시 ~~.do사용
				command = new AdminUserRecoverCommand(); // 커맨드(메소드)적기
				command.execute(request, response, session);
				viewPage = "AdminUserRecoverView.jsp"; // 실행할 jsp파일
				break;
				//리스트  검색시
			case("/AdminUserSearch.do"):
				command = new AdminuserSearchCommand();
				command.execute(request, response, session);
				viewPage = "AdminUserList.jsp";
				break;

				//-----------------------------------------도영

			
			//아이템목록
			case("/list.do"):
//				session.setAttribute("postsCount", 1);
				command = new LoadItemsCommand();
				command.execute(request, response, session);
				viewPage = "ListItem.jsp";
				break;
			
			//팁목록	
			case("/list2.do"):
//				session.setAttribute("postsCount", 1);
				command = new LoadTipsCommand();
				command.execute(request, response, session);
				viewPage = "ListTIp.jsp";
				break;
				
			//공지사항목록	
			case("/list3.do"):
//				session.setAttribute("postsCount", 1);
				command = new LoadNoticeCommand();
				command.execute(request, response, session);
				viewPage = "ListNotice.jsp";
				break;
			
			//리스트  검색시
			case("/search.do"):
				command = new SearchingCommand();
				command.execute(request, response, session);
				viewPage = "ListItem.jsp";
				break;
				
				
			//마이페이지 자기가 올린 게시물 보이게함
			case("/profile.do"):
				command = new LoadMyAllCommand();
				command.execute(request, response, session);
				viewPage = "Profile.jsp";
				break;
				
			//마이페이지에서 아이템게시물만 보이게	
			case("/profileOnlyTool.do"):
				command = new LoadMyItemCommand();
				command.execute(request, response, session);
				viewPage = "ProfileWithItem.jsp";
				break;
				
			//마이페이지에서 팁게시물만 보이게	
			case("/profileOnlyIdea.do"):
				command = new LoadMyTipCommand();
				command.execute(request, response, session);
				viewPage = "ProfileWithTip.jsp";
				break;
			
			//-------------------------------------도영

			//Tip 작성 및 수정
		
		//Tip 글 폼
		case("/TipViewBoard.do"): 	
		viewPage = "TipView.jsp";
		break;

			//Tip 글 작성하기
		case("/TipInsertBoard.do"): 
			command = new TipInsertCommand();
			command.execute(request, response, session);	
			int t_num = (int) request.getAttribute("result");
			if(t_num != 0) {
				viewPage = "ContentViewTips.do?t_num=" + t_num;
			}else {
				return;
			}
			break;
			
		case ("/ContentViewTips.do"): // 실행시 ~~.do사용
			command = new ContentTipCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "TipResultView.jsp"; // 실행할 jsp파일
			break;
			
			//Tip 글 불러오기
		case("/TipContentBoard.do"): 
			command = new TipContentCommand();
			command.execute(request, response, session);	
			viewPage = "TipUpdateBoard.jsp";
		break;

			//Tip 글 수정하기
		case("/TipUpdateBoard.do"): 
			command = new TipUpdateCommand();
			command.execute(request, response, session);	
			int t_num1 = (int) request.getAttribute("result");
			if(t_num1 != 0) {
				viewPage = "ContentViewTips.do?t_num=" + t_num1;
			}else {
				return;
			}
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
			int i_num = (int) request.getAttribute("result");
			if(i_num != 0) {
				viewPage = "ContentViewItems.do?i_num=" + i_num;
			}else {
				return;
			}
			break;
			
		case ("/ContentViewItems.do"): // 실행시 ~~.do사용
			command = new ContentItemCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "ItemInfoResultView.jsp"; // 실행할 jsp파일
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
			int i_num1 = (int) request.getAttribute("result");
			if(i_num1 != 0) {
				viewPage = "ContentViewItems.do?i_num=" + i_num1;
			}else {
				return;
			}
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
			int n_num = (int) request.getAttribute("result");
			if(n_num != 0) {
				viewPage = "ContentViewNotices.do?n_num=" + n_num;
			}else {
				return;
			}
			break;
			
		case ("/ContentViewNotices.do"): // 실행시 ~~.do사용
			command = new ContentNoticeCommand(); // 커맨드(메소드)적기
			command.execute(request, response, session);
			viewPage = "NoticeResultView.jsp"; // 실행할 jsp파일
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
			command.execute(request, response, session);	
			int n_num1 = (int) request.getAttribute("result");
			if(n_num1 != 0) {
				viewPage = "ContentViewNotices.do?n_num=" + n_num1;
			}else {
				return;
			}
			break;


		//도영 커맨드 추가;
		// 상대회원 정보 보기
		case("/userProfile.do"):
			command = new LoadUserInfo();
			command.execute(request, response, session);
			viewPage = "UserPage.jsp";
		break;

		case("/userOnlyItem.do"):
			command = new LoadUsersItem();
			command.execute(request, response, session);
			viewPage = "UserPageWithItem.jsp";
		break;
		
		case("/userOnlyTip.do"):
			command = new LoadUsersTip();
			command.execute(request, response, session);
			viewPage = "UserPageWithTip.jsp";
		break;
		
		// 카테고리로 보기
		
		//아이템목록
		case("/ComItem.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadComItemCommand();
			command.execute(request, response, session);
			viewPage = "ListItem.jsp";
		break;
		
		case("/AccItem.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadAccItemCommand();
			command.execute(request, response, session);
			viewPage = "ListItem.jsp";
		break;
		
		case("/DeskItem.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadDeskItemCommand();
			command.execute(request, response, session);
			viewPage = "ListItem.jsp";
		break;
		
		case("/OtherItem.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadOtherItemCommand();
			command.execute(request, response, session);
			viewPage = "ListItem.jsp";
		break;
		
		case("/CodeTip.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadCodeTipCommand();
			command.execute(request, response, session);
			viewPage = "ListTIp.jsp";
		break;
		
		case("/ProtoTip.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadProtoTipCommand();
			command.execute(request, response, session);
			viewPage = "ListTIp.jsp";
			break;
		
		case("/InfoTip.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadInfoTipCommand();
			command.execute(request, response, session);
			viewPage = "ListTIp.jsp";
			break;
			
		case("/OtherTip.do"):
			session.setAttribute("postsCount", 1);
			command = new LoadOtherTipCommand();
			command.execute(request, response, session);
			viewPage = "ListTIp.jsp";
			break;
		//---------------------------2021.05.27 도우
		case("/editView.do"):
			command = new EditProfileViewCommand();
			command.execute(request, response, session);
			viewPage = "EditProfile.jsp";
			break;
			
		//개인정보 수정
		case("/edit.do"):
			command = new EditProfileCommand();
			command.execute(request, response, session);
			viewPage = "infoedit.do";
			break;
		
		case("/infoedit.do"):
			command = new EditProfileViewCommand();
			command.execute(request, response, session);
		viewPage = "EditProfileEditSuccess.jsp";
		break;
		
		//비번 수정
		case("/changePassword.do"):
			command = new ChangePasswordCommand();
			command.execute(request, response, session);
			viewPage = "pwd.do";
		break;
		
		case("/pwd.do"):
			command = new EditProfileViewCommand();
			command.execute(request, response, session);
			viewPage = "EditProfilePwdSuccess.jsp";
		break;
		
		//탈퇴	
		case("/deleteAccount.do"):
			command = new DeleteAccountCommand();
			command.execute(request, response, session);
			viewPage = "LoginNowWithdraw.jsp";
		break;
		}		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}//---------------
