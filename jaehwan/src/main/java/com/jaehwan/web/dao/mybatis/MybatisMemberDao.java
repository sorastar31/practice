package com.jaehwan.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaehwan.web.dao.MemberDao;
import com.jaehwan.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Member member) {
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		return memberDao.insert(member);
	}

	@Override
	public int update(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		return memberDao.update(member);
	}

	@Override
	public int delete(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.delete(id);
	}

	@Override
	public Member get(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		return memberDao.get(id);
	}

	@Override
	public List<Member> getList() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList();
	}

	@Override
	public List<Member> getList(int page) {
		return getList("id","",1);
	}

	@Override
	public List<Member> getList(String field, String query) {
		return getList(field, query,1);
	}

	@Override
	public List<Member> getList(String field, String query, int page) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
	
		return memberDao.getList(field, query, page);
	}

	@Override
	public Member getByEmail(String email) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		return memberDao.getByEmail(email);
	}



}
