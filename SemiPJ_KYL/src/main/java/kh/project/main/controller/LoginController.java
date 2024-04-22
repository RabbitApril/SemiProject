package kh.project.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.member.model.dao.MemberDao;
import kh.project.member.model.dto.MemberDto;
import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;
import kh.project.member.model.servicce.MemberService;

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
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println("/login doPost dto : " + dto);
		
		// ajax 방식, 성공 : 1 , 실패 : 0 
		int result = 0; 
		MemberInfoDto resultInfo = service.loginGetInfo(dto);
		if(resultInfo != null) {
			request.getSession().setAttribute("aceptLogin", resultInfo);
			result = 1;
		}
		response.getWriter().append(String.valueOf(result));
	}

}
