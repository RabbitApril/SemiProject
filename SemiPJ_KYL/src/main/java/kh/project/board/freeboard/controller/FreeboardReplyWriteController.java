package kh.project.board.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.project.board.freeboard.model.dto.FreeBoardReplyListDto;
import kh.project.board.freeboard.model.dto.FreeBoardReplyWriteDto;
import kh.project.board.freeboard.model.service.FreeBoardService;

/**
 * Servlet implementation class FreeboardReplyWriteController
 */
@WebServlet("/community/reply/write.ajax")
public class FreeboardReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreeBoardService service = new FreeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeboardReplyWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/community/reply/write.ajax doPost() - test");
		String boardReplyIdStr = request.getParameter("boardReplyId");
		int boardReplyId = 0;
		String boardIdStr = request.getParameter("boardId");
		int boardId = 0;
		String boardReplyContent = request.getParameter("boardReplyContent");
		String memId = request.getParameter("memId");
		String boardReplyLogIp = null;
		
		Gson gson = new Gson();
		
		if(boardIdStr == null || boardIdStr.equals("")) {
			response.getWriter().append("-1");
			return;
		}
		
		if(boardIdStr != null && !boardIdStr.equals("")) {
			try {
				boardId = Integer.parseInt(boardIdStr);
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
		
		FreeBoardReplyWriteDto dto = new FreeBoardReplyWriteDto(boardReplyId, boardId, memId, boardReplyContent, boardReplyLogIp);
		int result = service.insertReply(dto);
		
		if(result > 0) {
			List<FreeBoardReplyListDto> replydtolist = service.selectFreeBoardReplyList(boardId);
			response.getWriter().append(gson.toJson(replydtolist));
		}
	}
}
