package kh.project.member.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.project.member.model.dao.MemberDao;
import kh.project.member.model.dto.MemberDto;
import kh.project.member.model.dto.MemberInfoDto;
import kh.project.member.model.dto.MemberLoginDto;

import static kh.project.jdbc.common.MybatisTemplate.*;


public class MemberService {
	private MemberDao dao = new MemberDao();
	
	// select Login get Info
	public MemberInfoDto loginGetInfo(MemberLoginDto dto) {
		MemberInfoDto result = null;
		SqlSession session = getSqlSession();
		result = dao.loginGetInfo(session, dto);
		session.close();
		return result;
	}
	
	// select Login
	public int login(MemberLoginDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.login(session, dto);
		session.close();
		return result;
	}
	
	// select checkId
	public int selectCheckId(String memId) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.selectCheckId(session, memId);
		session.close();
		return result;
	}
	
	// select checkNick
		public int selectCheckNick(String memNick) {
			int result = 0;
			SqlSession session = getSqlSession();
			result = dao.selectCheckNick(session, memNick);
			session.close();
			return result;
		}
	
	// select list - all
	public List<MemberDto> selectAllList() {
		List<MemberDto> result = null;
		SqlSession session = getSqlSession();
		result = dao.selectAllList(session);
		session.close();
		return result;
	}
	
	// select one
	public MemberDto selectOne(String memId) {
		MemberDto result = null;
		SqlSession session = getSqlSession();
		result = dao.selectOne(session, memId);
		session.close();
		return result;
	}
	
	// insert
	public int insert(MemberDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.insert(session, dto);
		session.close();
		return result;
	}
	
	// update
	public int update(MemberDto dto) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.update(session, dto);
		session.close();
		return result;
	}
	
	// delete
	public int delete(String memId) {
		int result = 0;
		SqlSession session = getSqlSession();
		result = dao.delete(session, memId);
		session.close();
		return result;
	}
}
