package kh.project.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.member.model.servicce.MemberService;

/**
 * Servlet implementation class CheckEmailController
 */
@WebServlet("/checkNickname.ajax")
public class CheckNicknameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNicknameController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b1 = request.getParameter("b1");
		String b2 = request.getParameter("b2");
		
		String memNick = request.getParameter("cnick");
		
		// DB로 전송
		int result = new MemberService().selectCheckId(memNick);
		response.getWriter().append(String.valueOf(result));
	}

}
