package kh.project.board.noticeboard.model.service;

import static kh.project.jdbc.common.MybatisTemplate.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.project.board.noticeboard.model.dao.NoticeBoardDao;
import kh.project.board.noticeboard.model.dto.NoticeBoardDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardFileReadDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardInsertDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardListDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardReadDto;

public class NoticeBoardService {
	private NoticeBoardDao dao = new NoticeBoardDao();

	public Map<String, Object> selectPageListMybatis(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = getSqlSession();
		List<NoticeBoardListDto> noticeboardList = dao.selectPageListRowBounds(session, pageSize, currentPageNum);
		session.close();
		return result;
	}

	// select list - all
	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = getSqlSession();

		int start = pageSize * (currentPageNum - 1) + 1;
		int end = pageSize * currentPageNum;

		int totalCount = dao.selectTotalCount(session);
		int totalPageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;

		int startPageNum = (currentPageNum % pageBlockSize == 0)
				? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1
				: ((currentPageNum / pageBlockSize)) * pageBlockSize + 1;
		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount
				: startPageNum + pageBlockSize - 1;

		List<NoticeBoardListDto> dtolist = dao.selectPageList(session, start, end);
		session.close();

		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);

		return result;
	}

	// select list - all
	public List<NoticeBoardListDto> selectAllList() {
		List<NoticeBoardListDto> result = null;
		SqlSession session = getSqlSession();
		result = dao.selectAllList(session);
		session.close();

		return result;

	}

	// select one
	public NoticeBoardReadDto selectOne(Integer boardId) {
		NoticeBoardReadDto result = null;
		SqlSession session = getSqlSession();
		result = dao.selectOne(session, boardId);
		if (result != null) {
			dao.updateReadCount(session, boardId);
		}
		List<NoticeBoardFileReadDto> filelist = dao.selectFileList(session, boardId);
		result.setFiledtolist(filelist);
		session.close();

		return result;
	}

	// insert
	public int insert(NoticeBoardInsertDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.insert(session, dto);
		session.close();
		return result;
	}
	
	// update
	public int update(NoticeBoardDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.update(session, dto);
		session.close();
		return result;
	}
	
	// delete
	public int delete(Integer boardId) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.delete(session, boardId);
		session.close();
		return result;
	}
}
