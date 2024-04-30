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

import kh.project.board.noticeboard.model.dto.NoticeBoardDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardFileReadDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardInsertDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardListDto;
import kh.project.board.noticeboard.model.dto.NoticeBoardReadDto;

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
	
	public int selectTotalCount(Connection conn) {
		int result = 0;
		String sql = "SELECT COUNT(*) CNT FROM NOTICEBOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = rs.getInt("cnt");
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
	
	public List<NoticeBoardListDto> selectAllList(Connection conn) {
		List<NoticeBoardListDto> result = null;
		String sql = "SELECT NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_TIME, ADM_ID FROM NOTICEBOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = new ArrayList<NoticeBoardListDto>();
				do {
					NoticeBoardListDto dto = new NoticeBoardListDto(
							rs.getInt("NOTICE_ID"), rs.getString("NOTICE_TITLE"),
							rs.getString("NOTICE_CONTENT"), rs.getString("NOTICE_TIME"),
							rs.getString("ADM_ID")
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
	
	// select one
	public NoticeBoardReadDto selectOne(Connection conn, Integer noticeId) {
		NoticeBoardReadDto result = null;
		String sql = "SELECT NOTICE_ID, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_TIME, ADM_ID FROM NOTICEBOARD WHERE NOTICE_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setInt(1, noticeId);
			rs = pstmt.executeQuery();
			// ResetSet 처리
			if(rs.next()) {
				result = new NoticeBoardReadDto(
						rs.getInt("NOTICE_ID"), rs.getString("NOTICE_TITLE"), 
						rs.getString("NOTICE_CONTENT"), rs.getString("NOTICE_TIME"), 
						rs.getString("ADM_ID")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	public int getSequenceNum(Connection conn) {
		int result = 0;
		String sql = "SELECT SEQ_NOTICEBOARD_ID.NEXTVAL FROM DUAL";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	public int insert(Connection conn, NoticeBoardInsertDto dto) {
		System.out.println("noticeboardDao insert() param : " + dto);
		int result = 0;
		
		// session
		System.out.println("noticeboardDao insert() return : " + result);
		return result;
	}
	
	public int update(Connection conn, NoticeBoardDto dto) {
		int result = 0;
		String sql = "UPDATE NOTICEBOARD INTO NOTICE_TITLE=?, NOTICE_CONTENT=?, NOTICE_TIME=? WHERE ADM_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setString(1, dto.getNoticeTitle());
			pstmt.setString(2, dto.getNoticeContent());
			pstmt.setString(3, dto.getNoticeTime());
			pstmt.setString(4, dto.getAdmId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	public int delete(Connection conn, Integer noticeId) {
		int result = 0;
		String sql = "DELETE FROM NOTICEBOARD WHERE NOTICE_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setInt(1, noticeId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
}
