package kh.project.main.controller;

import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;
import kh.project.member.model.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage = request.getParameter("prePage");
		request.getSession().setAttribute("prePage", prePage);
		request.getRequestDispatcher("/WEB-INF/views/main/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String checkbox = request.getParameter("checkbox");
		
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		Cookie cookie = new Cookie("memId", id); //쿠키 생성 
		System.out.println("/login doPost dto : " + dto);
		System.out.println(checkbox);
		
		if(checkbox != null) { //체크박스 체크여부에 따라 쿠키 저장 확인
			
			// 체크박스 체크 시 쿠키 저장
			response.addCookie(cookie);
		} else {
			// 체크박스 해제 시 쿠키 유효시간 0으로 해 브라우저에서 삭제
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// ajax 방식, 성공 : 1 , 실패 : 0 
		int result = 0; 
		System.out.println(dto);
		MemberInfoDto resultInfo = service.loginGetInfo(dto);
		if(resultInfo != null) {
			request.getSession().setAttribute("aceptLogin", resultInfo);
			result = 1;
		}
		response.getWriter().append(String.valueOf(result));
	}

}
