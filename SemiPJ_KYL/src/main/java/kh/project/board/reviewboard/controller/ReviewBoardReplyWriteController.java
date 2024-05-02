package kh.project.board.reviewboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.project.board.reviewboard.model.dto.ReviewBoardReplyListDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReplyWriteDto;
import kh.project.board.reviewboard.model.service.ReviewBoardService;

/**
 * Servlet implementation class ReviewBoardReplyWriteController
 */
@WebServlet("/review/reply/write.ajax")
public class ReviewBoardReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService service = new ReviewBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardReplyWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/reply/write.ajax doPost()");
		String boardReplyIdStr = request.getParameter("boardReplyId");
		int boardReplyId = 0;
		String reviewIdStr = request.getParameter("reviewId");
		int reviewId = 0;
		String boardReplyContent = request.getParameter("boardReplyContent");
		String memId = request.getParameter("memId");
		String boardReplyLogIp = null;
		
		Gson gson = new Gson();
		
		if(reviewIdStr == null || reviewIdStr.equals("")) {
			response.getWriter().append("-1");
			return;
		}
		
		if(reviewIdStr != null && !reviewIdStr.equals("")) {
			try {
				reviewId = Integer.parseInt(reviewIdStr);
			} catch (NumberFormatException e) {
				response.getWriter().append("-1");
				return;
			}
		}
		
		if(boardReplyIdStr != null && !boardReplyIdStr.equals("")) {
			try {
				boardReplyId = Integer.parseInt(boardReplyIdStr);
			}catch (NumberFormatException e) {
				response.getWriter().append("-1");
				return;
			}
		}
		
		if(boardReplyIdStr == null || boardReplyIdStr.equals("")) {
			// 댓글 원본으로 지정
			boardReplyId = 0;
		}
		
		ReviewBoardReplyWriteDto dto = new ReviewBoardReplyWriteDto(boardReplyId, reviewId, memId, boardReplyContent, boardReplyLogIp);
		int result = service.insertReply(dto);
		
		if(result > 0) {
			List<ReviewBoardReplyListDto> replydtolist = service.selectReviewBoardReplyList(reviewId);
			response.getWriter().append(gson.toJson(replydtolist));
		}
	}

}
