package kh.project.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.project.jdbc.common.JdbcTemplate.*;

import kh.project.member.model.dto.MemberDto;
import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;

public class MemberDao {
	
	// select one login
	public MemberInfoDto loginGetInfo(SqlSession session, MemberLoginDto dto) {
		return session.selectOne("memberMapper.loginGetInfo", dto);
	}
	
	// select one login
	public int login(SqlSession session, MemberLoginDto dto) {
		return session.selectOne("memberMapper.login", dto);
	}
	
	// select one check id
	public int selectCheckId(SqlSession session, String memId) {
		return session.selectOne("memberMapper.selectCheckId", memId);
	}
	
	// select one check id
	public int selectCheckNick(SqlSession session, String memNick) {
		return session.selectOne("memberMapper.selectCheckNick", memNick);
	}
	
	
	// select list - all
	public List<MemberDto> selectAllList(SqlSession session) {
		return session.selectList("memberMapper.selectAllList");
	}
		
	// select one
	public MemberDto selectOne(SqlSession session, String memId) {
		return session.selectOne("memberMapper.selectOne", memId);
	}
	// insert
	public int insert(SqlSession session, MemberDto dto) {
		return session.insert("memberMapper.insert", dto);
	}
	// update
	public int update(SqlSession session, MemberDto dto) {
		return session.delete("memberMapper.update", memId);
	}
	// delete
	public int delete(SqlSession session, String memId) {
		return session.delete("memberMapper.delete", memId);
	}
}
