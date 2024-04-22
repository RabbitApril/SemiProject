package kh.project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.project.jdbc.common.JdbcTemplate.*;

import kh.project.member.model.dto.MemberDto;
import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;

public class MemberDao {
	
	//select one login
	public MemberInfoDto loginGetInfoDto(Connection conn, MemberLoginDto dto) {
		MemberInfoDto result = null;
		String sql = "SELECT MEM_ID, MEM_EMAIL, MEM_NICK, MEM_GRADE FROM MEMBER WHERE MEM_ID=? AND MEM_PWD=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			rs = pstmt.executeQuery();
			
			// ResetSet 처리 
			if(rs.next()) {
				result = new MemberInfoDto(rs.getString("MEM_ID"), rs.getString("MEM_EMAIL"), rs.getString("MEM_NICK"), rs.getInt("MEM_GRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	// Login
	public int login(Connection conn, MemberLoginDto dto) {
		int result = 0;
		String sql = "SELECT COUNT (*) c FROM MEMBER WHERE MEM_ID=? AND MEM_PWD=? AND MEM_GRADE=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			rs = pstmt.executeQuery();
			
			// ResetSet 처리 
			if(rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	// select one check id  
	public int selectCheckId(Connection conn, String memId) {
		int result = 0;
		String sql = "SELECT COUNT (*) c FROM MEMBER WHERE MEM_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	// select one check email 
	public int selectCheckEmail(Connection conn, String memEmail) {
		int result = 0;
		String sql = "SELECT COUNT (*) c FROM MEMBER WHERE MEM_EMAIL=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			pstmt.setString(1, memEmail);
			rs = pstmt.executeQuery();
			// ResetSet 처리 
			if(rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	// select list - all 
	public List<MemberDto> selectAllList(Connection conn) {
		System.out.println("MemberDao selectAllList");
		List<MemberDto> result = null;
		String sql = "SELECT MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NICK, MEM_GRADE FROM MEMBER";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리 
			rs = pstmt.executeQuery();
			// ResetSet 처리
			if(rs.next()) {
				result = new ArrayList<MemberDto>();
				do {
					MemberDto dto = new MemberDto(rs.getString("MEM_ID"), rs.getString("MEM_PWD"), rs.getString("MEM_EMAIL"), rs.getString("MEM_NICK"), rs.getInt("MEM_GRADE"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		System.out.println("MemberDao selectAlllist : " + result);
		return result;
	}
	
	
	public MemberDto selectOne(Connection conn, String memId) {
		MemberDto result = null;
		String sql = "SELECT MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NICK, MEM_GRADE FROM MEMBER WHERE MEM_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?처리
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			// ResetSet 처리
			if(rs.next()) {
				result = new MemberDto(rs.getString("MEM_ID"), rs.getString("MEM_PWD"), rs.getString("MEM_EMAIL"), rs.getString("MEM_NICK"), rs.getInt("MEM_GRADE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	public int insert(Connection conn, MemberDto dto) {
		int result = 0;
//		INSERT INTO MEMBER VALUES ('ampres15','namesies15','ampres1215@naver.com','하르하르','1');
		String sql = "INSERT INTO MEMBER (MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NICK, MEM_GRADE) VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			pstmt.setString(3, dto.getMemEmail());
			pstmt.setString(4, dto.getMemNick());
			pstmt.setInt(5, dto.getMemGrade());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
	
	
	public int delete(Connection conn, String memId) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE MEM_ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setString(1, memId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		return result;
	}
}
