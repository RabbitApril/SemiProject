package kh.project.board.reviewboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.project.board.reviewboard.model.service.ReviewBoardService;

/**
 * Servlet implementation class ReviewBoardListController
 */
@WebServlet("/review/list")
public class ReviewBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService service = new ReviewBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한페이지당 글 수는 10개씩 나오게끔 지정
		int pageSize = 10;
		// 하단 페이지수는 10개부터 
		int pageBlockSize = 10;
		// 처음 페이지 
		int currentPageNum = 1;
		// 페이지지정시 현재 페이지를 값으로 지정함
		String pageNum = request.getParameter("page");
		if(pageNum!= null && !pageNum.equals("")) {
			try {
				currentPageNum = Integer.parseInt(pageNum);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("map", service.selectPageList(pageSize, pageBlockSize, currentPageNum));
		request.getRequestDispatcher("/WEB-INF/views/board/reviewboard/reviewboard.jsp").forward(request, response);
	}

}
