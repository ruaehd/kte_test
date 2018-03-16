package com.kte.mvc.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V6_Member;

@Service
public class V6_MemberDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public int insertMember(V6_Member vo) {
		return sqlsession.insert("V6_Member.insertMember", vo);
	}
	
	public int selectMemcNo() {
		return sqlsession.selectOne("V6_Member.selectMemcNo");
	}
	
	public List<V6_Member> selectMemberList() {
		return sqlsession.selectList("V6_Member.selectMemberList");
	}
	
	public int updateMemberAll(List<V6_Member> list) {
		return sqlsession.update("V6_Member.updateMemberAll", list);
	}
	
	public int deleteMemberAll(List<String> list) {
		return sqlsession.delete("V6_Member.deleteMemberAll", list);
	}
	
	public void deleteMemberProc(Map<String, Object> map) {
		sqlsession.selectOne("V6_Member.deleteMemberProc", map);
	}
	
	public V6_Member selectMemberLogin(V6_Member vo) {
		return sqlsession.selectOne("V6_Member.selectMemberLogin", vo);
	}
}
