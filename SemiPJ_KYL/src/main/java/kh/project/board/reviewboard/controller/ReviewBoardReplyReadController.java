package kh.project.board.reviewboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.project.board.reviewboard.model.service.ReviewBoardService;

/**
 * Servlet implementation class ReviewBoardReplyReadController
 */
@WebServlet("/review/reply/read.ajax")
public class ReviewBoardReplyReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService service = new ReviewBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardReplyReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewIdStr = request.getParameter("reviewId");
		try {
			int reviewId = Integer.parseInt(reviewIdStr);
			response.getWriter().append(new Gson().toJson(service.selectReviewBoardReplyList(reviewId)));
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException.");
			response.sendRedirect(request.getContextPath()+"review/list");
		}
	}

}
