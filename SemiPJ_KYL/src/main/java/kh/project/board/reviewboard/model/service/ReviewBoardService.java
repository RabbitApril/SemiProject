package kh.project.board.reviewboard.model.service;

import static kh.project.jdbc.common.MybatisTemplate.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.project.board.reviewboard.model.dao.ReviewBoardDao;
import kh.project.board.reviewboard.model.dto.ReviewBoardDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardFileReadDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardInsertDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardListDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReadDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReplyListDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReplyWriteDto;

public class ReviewBoardService {
	private ReviewBoardDao dao = new ReviewBoardDao();
	
	public Map<String, Object> selectPageListMybatis(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = getSqlSession();
		List<ReviewBoardListDto> reviewboardList = dao.selectPageListRowBounds(session, pageSize, currentPageNum);
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

		List<ReviewBoardListDto> dtolist = dao.selectPageList(session, start, end);
		session.close();

		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);

		return result;
	}

	// select list - Reviewboard reply
	public List<ReviewBoardReplyListDto> selectReviewBoardReplyList(Integer reviewId) {
		List<ReviewBoardReplyListDto> result = null;
		SqlSession session = getSqlSession(true);
		result = dao.selectReviewBoardReplyList(session, reviewId);
		session.close();

		return result;
	}

	// select list - all
	public List<ReviewBoardListDto> selectAllList() {
		List<ReviewBoardListDto> result = null;
		SqlSession session = getSqlSession();
		result = dao.selectAllList(session);
		session.close();

		return result;

	}

	// select one
	public ReviewBoardReadDto selectOne(Integer reviewId) {
		ReviewBoardReadDto result = null;
		SqlSession session = getSqlSession();
		result = dao.selectOne(session, reviewId);
		if (result != null) {
			dao.updateReadCount(session, reviewId);
		}
		List<ReviewBoardFileReadDto> filelist = dao.selectFileList(session, reviewId);
		result.setFiledtolist(filelist);
		session.close();

		return result;
	}

	// insert - reviewboardReply
	public int insertReply(ReviewBoardReplyWriteDto dto) {
		int result = 0;
		int resultupdate = 0;
		SqlSession session = getSqlSession(false);
		if (dto.getBoardReplyId() != 0) {
			resultupdate = dao.updateReplyStep(session, dto.getBoardReplyId());
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
	public int insert(ReviewBoardInsertDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.insert(session, dto);
		session.close();
		return result;
	}
	
	// update
	public int update(ReviewBoardDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.update(session, dto);
		session.close();
		return result;
	}
	
	// delete
	public int delete(Integer reviewId) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.delete(session, reviewId);
		session.close();
		return result;
	}
}
