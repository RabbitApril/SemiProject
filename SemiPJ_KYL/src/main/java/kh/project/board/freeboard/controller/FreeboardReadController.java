package kh.project.board.freeboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.board.freeboard.model.service.FreeBoardService;

/**
 * Servlet implementation class FreeboardReadController
 */
@WebServlet("/community/read")
public class FreeboardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreeBoardService service = new FreeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeboardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("id");
		try {
			int boardId = Integer.parseInt(boardIdStr);
			request.setAttribute("dto", service.selectOne(boardId));
			request.getRequestDispatcher("/WEB-INF/views/board/freeboard/freeboardRead.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException.");
			response.sendRedirect(request.getContextPath()+"community/list");
		}
	}
}
