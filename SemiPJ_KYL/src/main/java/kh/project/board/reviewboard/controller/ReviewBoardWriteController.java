package kh.project.board.reviewboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.project.board.reviewboard.model.dto.ReviewBoardFileWriteDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardInsertDto;
import kh.project.board.reviewboard.model.service.ReviewBoardService;
import kh.project.member.model.dto.MemberInfoDto;

/**
 * Servlet implementation class ReviewBoardWriteController
 */
@WebServlet("/review/write")
public class ReviewBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewBoardService service = new ReviewBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewBoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/reviewboard/reviewwrite.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/review/write doPost() - test");
		
		// 파일 정보 받아오기 
		String uploadPath = request.getServletContext().getRealPath("files");
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 100 * 1024 *1024; // 100M제한
		
		MultipartRequest multiReq = new MultipartRequest(request, uploadPath, uploadFileLimit, "UTF-8", new DefaultFileRenamePolicy());
		
		List<ReviewBoardFileWriteDto> fileList = new ArrayList<ReviewBoardFileWriteDto>();
		
		Enumeration<?> fileNames = multiReq.getFileNames();
		while(fileNames.hasMoreElements()) {
			String name = (String)fileNames.nextElement();
			String fileName = multiReq.getFilesystemName(name);
			String orginFileName = multiReq.getOriginalFileName(name);
			String type = multiReq.getContentType(name);
			
			File f1= multiReq.getFile(name); 
			if(f1 == null) {
				System.out.println("업로드 실패");
			}
			
			ReviewBoardFileWriteDto filedto = new ReviewBoardFileWriteDto(fileName, orginFileName);
			fileList.add(filedto);
		}
		
		String subject = multiReq.getParameter("subject");
		String content = multiReq.getParameter("editor");
		MemberInfoDto memberInfoDto = (MemberInfoDto)request.getSession().getAttribute("aceptLogin");
		ReviewBoardInsertDto dto = new ReviewBoardInsertDto(subject, content, memberInfoDto.getMemId(), fileList);
		
		int result = service.insert(dto);
		response.sendRedirect(request.getContextPath()+"/review/list");
	}
}
