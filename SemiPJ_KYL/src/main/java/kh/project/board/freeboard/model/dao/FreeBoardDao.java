package kh.project.board.freeboard.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kh.project.board.freeboard.model.dto.FreeBoardDto;
import kh.project.board.freeboard.model.dto.FreeBoardFileReadDto;
import kh.project.board.freeboard.model.dto.FreeBoardInsertDto;
import kh.project.board.freeboard.model.dto.FreeBoardListDto;
import kh.project.board.freeboard.model.dto.FreeBoardReadDto;
import kh.project.board.freeboard.model.dto.FreeBoardReplyListDto;
import kh.project.board.freeboard.model.dto.FreeBoardReplyWriteDto;

public class FreeBoardDao {
	// select list - all
	public List<FreeBoardFileReadDto> selectFileList(SqlSession session, Integer boardId) {
		return session.selectList("freeboardMapper.selectFileList", boardId);
	}
	
	// select list - freeboard reply
	public List<FreeBoardReplyListDto> selectFreeBoardReplyList(SqlSession session, Integer boardId) {
		return session.selectList("freeboardMapper.selectFreeBoardReplyList", boardId);
	}
	
	//select total Count 
	public Integer selectTotalCount(SqlSession session) {
		return session.selectOne("freeboardMapper.selectTotalCount");
	}
	
	public List<FreeBoardListDto> selectPageListRowBounds(SqlSession session, int pageSize, int currentPageNum) {
		int offset = (currentPageNum - 1) * pageSize;
		RowBounds rbounds = new RowBounds( offset , pageSize);
		return session.selectList("freeboardMapper.selectPageListRowBounds", null, rbounds);
	}
	
	// select list - all
	public List<FreeBoardListDto> selectPageList(SqlSession session, int start, int end) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startRownum", start);
		param.put("endRownum", end);
		return session.selectList("freeboardMapper.selectPageList",param);
	}
	
	// select list - all
	public List<FreeBoardListDto> selectAllList(SqlSession session) {
		return session.selectList("freeboardMapper.selectAllList");
	}
	
	// select one 
	public FreeBoardReadDto selectOne(SqlSession session, Integer boardId) {
		return session.selectOne("freeboardMapper.selectOne", boardId);
	}
	
	// select 
	public Integer getSequenceNum(SqlSession session) {
		return session.selectOne("freeboardMapper.getSequenceNum");
	}
	
	// insert - Replyreply
	public int insertRReply(SqlSession session, FreeBoardReplyWriteDto dto) {
		return session.insert("freeboardMapper.insertRReply", dto);
	}
	
	// insert - Reply origin
	public int insertReply(SqlSession session, FreeBoardReplyWriteDto dto) {
		return session.insert("freeboardMapper.insertReply", dto);
	}
	
	// insert 
	public int insert(SqlSession session, FreeBoardInsertDto dto) {
		return session.insert("freeboardMapper.insert", dto);
	}
	
	// update - reply Step
	public int updateReplyStep(SqlSession session, Integer boardReplyId) {
		return session.update("freeboardMapper.updateReplyStep",boardReplyId);
	}
	
	// update - readCount
	public int updateReadCount(SqlSession session, Integer boardId) {
		return session.update("freeboardMapper.updateReadCount", boardId);
	}
	
	// update 
	public int update(SqlSession session, FreeBoardDto dto) {
		return session.update("freeboardMapper.update", dto);
	}
	
	// delete
	public int delete(SqlSession session, Integer boardId) {
		return session.delete("freeboardMapper.delete", boardId);
	}
}
