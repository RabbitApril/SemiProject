package kh.project.board.noticeboard.controller;

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

import kh.project.board.noticeboard.model.dto.NoticeBoardFileWriteDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardInsertDto;
import kh.project.board.noticeboard.model.service.NoticeBoardService;
import kh.project.member.model.dto.MemberInfoDto;

/**
 * Servlet implementation class NoticeBoardWriteController
 */
@WebServlet("/notice/write")
public class NoticeBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeBoardService service = new NoticeBoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeBoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/noticeboard/noticewrite.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/notice/write doPost() - test");
		
		// 파일 정보 받아오기 
		String uploadPath = request.getServletContext().getRealPath("files");
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 100 * 1024 *1024; // 100M제한
				
		MultipartRequest multiReq = new MultipartRequest(request, uploadPath, uploadFileLimit, "UTF-8", new DefaultFileRenamePolicy());
				
		List<NoticeBoardFileWriteDto> fileList = new ArrayList<NoticeBoardFileWriteDto>();
				
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
					
			NoticeBoardFileWriteDto filedto = new NoticeBoardFileWriteDto(fileName, orginFileName);
			fileList.add(filedto);
			System.out.println("여기여기 파일 저장 후");
		}
		System.out.println(fileList);
				
		String subject = multiReq.getParameter("subject");
		String content = multiReq.getParameter("editor");
		MemberInfoDto memberInfoDto = (MemberInfoDto)request.getSession().getAttribute("aceptLogin");
		NoticeBoardInsertDto dto = new NoticeBoardInsertDto(subject, content, memberInfoDto.getMemId(), fileList);
		System.out.println("review write: param:");
		System.out.println(dto);
		int result = service.insert(dto);
		response.sendRedirect(request.getContextPath()+"/notice/list");
	}		
}
