package kh.project.board.reviewboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.board.reviewboard.model.service.ReviewBoardService;

/**
 * Servlet implementation class ReviewBoardReadController
 */
@WebServlet("/review/read")
public class ReviewBoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService service = new ReviewBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewIdStr = request.getParameter("reviewId");
		try {
			int reviewId = Integer.parseInt(reviewIdStr);
			request.setAttribute("dto", service.selectOne(reviewId));
			request.getRequestDispatcher("/WEB-INF/views/board/reviewboard/reviewboardRead.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException.");
			response.sendRedirect(request.getContextPath()+"review/list");
		}
	}

}
