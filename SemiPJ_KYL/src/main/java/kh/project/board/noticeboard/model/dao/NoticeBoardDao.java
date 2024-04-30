package kh.project.board.noticeboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import static kh.project.jdbc.common.JdbcTemplate.*;

import kh.project.board.noticeboard.model.dto.NoticeBoardFileReadDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardListDto;

public class NoticeBoardDao {
	// select list - all 
	public List<NoticeBoardFileReadDto> selectNoticeBoardFileList(Connection conn, Integer noticeId) {
		List<NoticeBoardFileReadDto> result = null;
//		SELECT NOTICE_ID, BOARD_FILE_ID, ORIGINAL_FILENAME, SAVED_FILE_PATH_NAME FROM NOTICE_FILE WHERE NOTICE_ID='1';
		String sql = "SELECT NOTICE_ID, BOARD_FILE_ID, ORIGINAL_FILENAME, SAVED_FILE_PATH_NAME FROM NOTICE_FILE WHERE NOTICE_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, noticeId);
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = new ArrayList<NoticeBoardFileReadDto>();
				do {
					NoticeBoardFileReadDto dto = new NoticeBoardFileReadDto(
							rs.getInt("NOTICE_ID"), rs.getInt("BOARD_FILE_ID"),
							rs.getString("ORIGINAL_FILENAME"), rs.getString("SAVED_FILE_PATH_NAME")
							);
					result.add(dto);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	public List<NoticeBoardListDto> selectPageListMybatis(SqlSession session, int pageSize, int currentPageNum) {
		List<NoticeBoardListDto> result = null;
		int offset = (currentPageNum - 1) * pageSize;
		RowBounds rbounds = new RowBounds(offset, pageSize);
		result = session.selectList("noticeboardns.selectNoticePageList", null, rbounds);
		return result;
	}
	
	public List<NoticeBoardListDto> selectNoticePageList(Connection conn, int start, int end) {
		List<NoticeBoardListDto> result = null;
		return result;
	}
}
