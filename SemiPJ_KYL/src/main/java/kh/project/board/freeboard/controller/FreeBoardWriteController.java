package kh.project.board.freeboard.controller;

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

import kh.project.board.freeboard.model.dto.FreeBoardFileWriteDto;
import kh.project.board.freeboard.model.dto.FreeBoardInsertDto;
import kh.project.board.freeboard.model.service.FreeBoardService;
import kh.project.member.model.dto.MemberInfoDto;

/**
 * Servlet implementation class FreeBoardWriteController
 */
@WebServlet("/community/write")
public class FreeBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FreeBoardService service = new FreeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/communitywrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/community/write doPost() - test");
		
		// 파일 정보 받아오기 
		String uploadPath = request.getServletContext().getRealPath("files");
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 100 * 1024 *1024; // 100M제한
						
		MultipartRequest multiReq = new MultipartRequest(request, uploadPath, uploadFileLimit, "UTF-8", new DefaultFileRenamePolicy());
						
		List<FreeBoardFileWriteDto> fileList = new ArrayList<FreeBoardFileWriteDto>();
						
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
							
			FreeBoardFileWriteDto filedto = new FreeBoardFileWriteDto(fileName, orginFileName);
			fileList.add(filedto);
		}
						
		String subject = multiReq.getParameter("subject");
		String content = multiReq.getParameter("editor");
		MemberInfoDto memberInfoDto = (MemberInfoDto)request.getSession().getAttribute("aceptLogin");
		FreeBoardInsertDto dto = new FreeBoardInsertDto(subject, content, memberInfoDto.getMemId(), fileList);
						
		int result = service.insert(dto);
		response.sendRedirect(request.getContextPath()+"/community/list");
	}
}
