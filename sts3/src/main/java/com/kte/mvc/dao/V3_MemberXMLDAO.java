package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_Member;

@Service
public class V3_MemberXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V3_Member> selectMemberList(){
		return sqlsession.selectList("V3_Member.selectMemberList");
	}
	
	public int insertMember(V3_Member vo) {
		return sqlsession.insert("V3_Member.insertMember", vo);
	}
	
	public V3_Member selectMemberOne(String email) {
		return sqlsession.selectOne("V3_Member.selectMemberOne", email);
	}
	
	public int updateMember(V3_Member vo) {
		return sqlsession.update("V3_Member.updateMember", vo);
	}
	
	public int deleteMember(V3_Member vo) {
		return sqlsession.delete("V3_Member.deleteMember", vo);
	}
	
	public V3_Member selectMemberLogin(V3_Member vo) {
		return sqlsession.selectOne("V3_Member.selectMemberLogin", vo);
	}
	
	public int updateMemberPw(V3_Member vo) {
		return sqlsession.update("V3_Member.updateMemberPw", vo);
	}
}
