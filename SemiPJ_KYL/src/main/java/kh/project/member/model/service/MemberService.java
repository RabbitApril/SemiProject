package kh.project.member.model.service;

import java.sql.Connection;
import java.util.List;

import kh.project.member.model.dao.MemberDao;
import kh.project.member.model.dto.MemberDto;
import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;

import static kh.project.jdbc.common.JdbcTemplate.*;


public class MemberService {
	private MemberDao dao = new MemberDao();
	
	//select Login get Info
	public MemberInfoDto loginGetInfo(MemberLoginDto dto) {
		MemberInfoDto result = null;
		Connection conn = getSemiConnection(true);
		result = dao.loginGetInfoDto(conn, dto);
		close(conn);
		return result;
	}
	
	
	//select login
	public int login(MemberLoginDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.login(conn, dto);
		close(conn);
		return result;
	}
	
	
	// select checkId 
	public int selectCheckId(String memId) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.selectCheckId(conn, memId);
		close(conn);
		return result;
	}
	
	
	// select checkEmail
	public int selectCheckNick(String memNick) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.selectCheckNick(conn, memNick);
		close(conn);
		return result;
	}
	
	
	// select List - all
	public List<MemberDto> selectAllList() {
		List<MemberDto> result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectAllList(conn);
		close(conn);
		return result;
	}
	
	
	// select One
	public MemberDto selectOne(String memId) {
		MemberDto result = null;
		Connection conn = getSemiConnection(true);
		result = dao.selectOne(conn, memId);
		close(conn);
		return result;
	}
	
	
	// insert 
	public int insert(MemberDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	
	
	// delete
	public int delete(String memId) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.delete(conn, memId);
		close(conn);
		return result;
	}
}
