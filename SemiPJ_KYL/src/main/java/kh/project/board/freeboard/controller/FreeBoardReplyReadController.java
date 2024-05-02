package kh.project.board.freeboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.project.board.freeboard.model.service.FreeBoardService;

/**
 * Servlet implementation class FreeBoardReplyReadController
 */
@WebServlet("/community/reply/read.ajax")
public class FreeBoardReplyReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreeBoardService service = new FreeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("boardId");
		try {
			int boardId = Integer.parseInt(boardIdStr);
			response.getWriter().append(new Gson().toJson(service.selectFreeBoardReplyList(boardId)));
		}catch(NumberFormatException e) {
			System.out.println("!!! NumberFormatException !!!!!!");
			response.sendRedirect(request.getContextPath()+"community/list");
		}
	}
}
