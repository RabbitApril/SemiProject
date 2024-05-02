package kh.project.board.freeboard.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import static kh.project.jdbc.common.MybatisTemplate.*;

import kh.project.board.freeboard.model.dao.FreeBoardDao;
import kh.project.board.freeboard.model.dto.FreeBoardDto;
import kh.project.board.freeboard.model.dto.FreeBoardFileReadDto;
import kh.project.board.freeboard.model.dto.FreeBoardInsertDto;
import kh.project.board.freeboard.model.dto.FreeBoardListDto;
import kh.project.board.freeboard.model.dto.FreeBoardReadDto;
import kh.project.board.freeboard.model.dto.FreeBoardReplyListDto;
import kh.project.board.freeboard.model.dto.FreeBoardReplyWriteDto;

public class FreeBoardService {
	private FreeBoardDao dao = new FreeBoardDao();

	public Map<String, Object> selectPageListMybatis(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = getSqlSession();
		List<FreeBoardListDto> freeboardList = dao.selectPageListRowBounds(session, pageSize, currentPageNum);
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

		List<FreeBoardListDto> dtolist = dao.selectPageList(session, start, end);
		session.close();

		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);

		return result;
	}

	// select list - freeboard reply
	public List<FreeBoardReplyListDto> selectFreeBoardReplyList(Integer boardId) {
		List<FreeBoardReplyListDto> result = null;
		SqlSession session = getSqlSession(true);
		result = dao.selectFreeBoardReplyList(session, boardId);
		session.close();

		return result;
	}

	// select list - all
	public List<FreeBoardListDto> selectAllList() {
		List<FreeBoardListDto> result = null;
		SqlSession session = getSqlSession();
		result = dao.selectAllList(session);
		session.close();

		return result;

	}

	// select one
	public FreeBoardReadDto selectOne(Integer boardId) {
		FreeBoardReadDto result = null;
		SqlSession session = getSqlSession();
		result = dao.selectOne(session, boardId);
		if (result != null) {
			dao.updateReadCount(session, boardId);
		}
		List<FreeBoardFileReadDto> filelist = dao.selectFileList(session, boardId);
		result.setFiledtolist(filelist);
		session.close();

		return result;
	}

	// insert - freeboardReply
	public int insertReply(FreeBoardReplyWriteDto dto) {
		int result = 0;
		int resultupdate = 0;
		SqlSession session = getSqlSession(false);
		if (dto.getBoardReplyId() != 0) {
			resultupdate = dao.updateReplyStep(session, dto.getBoardReplyId());
			if (resultupdate > -1) {
				result = dao.insertRReply(session, dto);
			}
		} else {
			result = dao.insertReply(session, dto);
		}
		if (resultupdate > -1 && result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	// insert
	public int insert(FreeBoardInsertDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.insert(session, dto);
		session.close();
		return result;
	}
	
	// update
	public int update(FreeBoardDto dto) {
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
