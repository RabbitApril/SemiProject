package kh.project.board.noticeboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.board.noticeboard.model.service.NoticeBoardService;

/**
 * Servlet implementation class NoticeBoardReadController
 */
@WebServlet("/notice/read")
public class NoticeBoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeBoardService service = new NoticeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeBoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeIdStr = request.getParameter("id");
		try {
			int noticeId = Integer.parseInt(noticeIdStr);
			request.setAttribute("dto", service.selectOne(noticeId));
			request.getRequestDispatcher("/WEB-INF/views/board/noticeboard/noticeboardRead.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException.");
			response.sendRedirect(request.getContextPath()+"notice/list");
		}
	}

}
