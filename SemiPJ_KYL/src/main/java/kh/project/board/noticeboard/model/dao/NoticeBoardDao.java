package kh.project.board.noticeboard.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kh.project.board.noticeboard.model.dto.NoticeBoardDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardFileReadDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardInsertDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardListDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardReadDto;

public class NoticeBoardDao {
	// select list - all
		public List<NoticeBoardFileReadDto> selectFileList(SqlSession session, Integer noticeId) {
			return session.selectList("noticeboardMapper.selectFileList", noticeId);
		}
		
		//select total Count 
		public Integer selectTotalCount(SqlSession session) {
			return session.selectOne("noticeboardMapper.selectTotalCount");
		}
		
		public List<NoticeBoardListDto> selectPageListRowBounds(SqlSession session, int pageSize, int currentPageNum) {
			int offset = (currentPageNum - 1) * pageSize;
			RowBounds rbounds = new RowBounds( offset , pageSize);
			return session.selectList("noticeboardMapper.selectPageList", null, rbounds);
		}
		
		// select list - all
		public List<NoticeBoardListDto> selectPageList(SqlSession session, int start, int end) {
			Map<String, Integer> param = new HashMap<String, Integer>();
			param.put("startRownum", start);
			param.put("endRownum", end);
			return session.selectList("noticeboardMapper.selectPageList",param);
		}
		
		// select list - all
		public List<NoticeBoardListDto> selectAllList(SqlSession session) {
			return session.selectList("noticeboardMapper.selectAllList");
		}
		
		// select one 
		public NoticeBoardReadDto selectOne(SqlSession session, Integer noticeId) {
			return session.selectOne("noticeboardMapper.selectOne", noticeId);
		}
		
		// select 
		public Integer getSequenceNum(SqlSession session) {
			return session.selectOne("noticeboardMapper.getSequenceNum");
		}

		// insert 
		public int insert(SqlSession session, NoticeBoardInsertDto dto) {
			return session.insert("noticeboardMapper.insert", dto);
		}
		
		// update - readCount
		public int updateReadCount(SqlSession session, Integer noticeId) {
			return session.update("noticeboardMapper.updateReadCount", noticeId);
		}
		
		// update 
		public int update(SqlSession session, NoticeBoardDto dto) {
			return session.update("noticeboardMapper.update", dto);
		}
		
		// delete
		public int delete(SqlSession session, Integer noticeId) {
			return session.delete("noticeboardMapper.delete", noticeId);
		}
}
