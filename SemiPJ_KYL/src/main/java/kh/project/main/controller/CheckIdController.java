package kh.project.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.member.model.servicce.MemberService;

/**
 * Servlet implementation class CheckIdController
 */
@WebServlet("/checkId.ajax")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		
		String memId = request.getParameter("cid");
		
		// DB로 전송
		int result = new MemberService().selectCheckId(memId);
		response.getWriter().append(String.valueOf(result));
	}

}
