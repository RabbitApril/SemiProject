package kh.project.board.noticeboard.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import static kh.project.jdbc.common.JdbcTemplate.*;

import kh.project.board.noticeboard.model.dao.NoticeBoardDao;
import kh.project.board.noticeboard.model.dto.NoticeBoardDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardFileReadDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardInsertDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardListDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardReadDto;
import kh.project.mybatis.common.MybatisTemplate;

public class NoticeBoardService {
	private NoticeBoardDao dao = new NoticeBoardDao();
	
	public Map<String, Object> selectPageListMybatis(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = MybatisTemplate.getSqlSesisSession(true);
		
		List<NoticeBoardListDto> noticeboardList = dao.selectPageListMybatis(session, pageSize, currentPageNum);
		
		return result;
	}
	
	public Map<String, Object> selectNoticePageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		Connection conn = getSemiConnection(true);
		
		System.out.println("currentPageNum: " + currentPageNum);
		int start = pageSize * (currentPageNum - 1) +1;
		int end = pageSize * currentPageNum;
		
		int totalPageCount = dao.selectTotalCount(conn);
		int startPageNum = (currentPageNum % pageBlockSize == 0) ? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1 : ((currentPageNum / pageBlockSize)) * pageBlockSize + 1; 
		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount : startPageNum + pageBlockSize - 1;
		
		List<NoticeBoardListDto> dtolist = dao.selectNoticePageList(conn, start, end);
		close(conn);
		
		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		
		System.out.println("selectPageList() : " + result);
		
		return result;
	}
	
	// select list - all
	public List<NoticeBoardListDto> selectAllList() {
		List<NoticeBoardListDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;
	}
	
	public NoticeBoardReadDto selectOne(Integer noticeId) {
		NoticeBoardReadDto result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectOne(conn, noticeId);
		
		List<NoticeBoardFileReadDto> filelist = dao.selectNoticeBoardFileList(conn, noticeId);
		
		close(conn);
		return result;
	}
	
	//insert
	public int insert(NoticeBoardInsertDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	
	// update
	public int update(NoticeBoardDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	
	// delete
	public int delete(Integer noticeId) {
		int result = 0;
		Connection conn = null;
		result = dao.delete(conn, noticeId);
		close(conn);
		return result;
		}	
}
