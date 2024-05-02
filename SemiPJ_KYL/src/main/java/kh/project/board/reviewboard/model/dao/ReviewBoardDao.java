package kh.project.board.reviewboard.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kh.project.board.reviewboard.model.dto.ReviewBoardDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardFileReadDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardInsertDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardListDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReadDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReplyListDto;
import kh.project.board.reviewboard.model.dto.ReviewBoardReplyWriteDto;

public class ReviewBoardDao {
	// select list - all
		public List<ReviewBoardFileReadDto> selectFileList(SqlSession session, Integer reviewId) {
			return session.selectList("reviewboardMapper.selectFileList", reviewId);
		}
		
		// select list - reviewboard reply
		public List<ReviewBoardReplyListDto> selectReviewBoardReplyList(SqlSession session, Integer reviewId) {
			return session.selectList("reviewboardMapper.selectReviewBoardReplyList", reviewId);
		}
		
		//select total Count 
		public Integer selectTotalCount(SqlSession session) {
			return session.selectOne("reviewboardMapper.selectTotalCount");
		}
		
		public List<ReviewBoardListDto> selectPageListRowBounds(SqlSession session, int pageSize, int currentPageNum) {
			int offset = (currentPageNum - 1) * pageSize;
			RowBounds rbounds = new RowBounds( offset , pageSize);
			return session.selectList("reviewboardMapper.selectPageList", null, rbounds);
		}
		
		// select list - all
		public List<ReviewBoardListDto> selectPageList(SqlSession session, int start, int end) {
			Map<String, Integer> param = new HashMap<String, Integer>();
			param.put("startRownum", start);
			param.put("endRownum", end);
			return session.selectList("reviewboardMapper.selectPageList",param);
		}
		
		// select list - all
		public List<ReviewBoardListDto> selectAllList(SqlSession session) {
			return session.selectList("reviewboardMapper.selectAllList");
		}
		
		// select one 
		public ReviewBoardReadDto selectOne(SqlSession session, Integer reviewId) {
			return session.selectOne("reviewboardMapper.selectOne", reviewId);
		}
		
		// select 
		public Integer getSequenceNum(SqlSession session) {
			return session.selectOne("reviewboardMapper.getSequenceNum");
		}
		
		// insert - Reply origin
		public int insertReply(SqlSession session, ReviewBoardReplyWriteDto dto) {
			return session.insert("reviewboardMapper.insertReply", dto);
		}
		
		// insert 
		public int insert(SqlSession session, ReviewBoardInsertDto dto) {
			return session.insert("reviewboardMapper.insert", dto);
		}
		
		// update - reply Step
		public int updateReplyStep(SqlSession session, Integer boardReplyId) {
			return session.update("reviewboardMapper.updateReplyStep",boardReplyId);
		}
		
		// update - readCount
		public int updateReadCount(SqlSession session, Integer reviewId) {
			return session.update("reviewboardMapper.updateReadCount", reviewId);
		}
		
		// update 
		public int update(SqlSession session, ReviewBoardDto dto) {
			return session.update("reviewboardMapper.update", dto);
		}
		
		// delete
		public int delete(SqlSession session, Integer reviewId) {
			return session.delete("reviewboardMapper.delete", reviewId);
		}
}
