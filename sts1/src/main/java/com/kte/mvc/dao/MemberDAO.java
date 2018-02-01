package com.kte.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_MemberVO;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession sqlsession = null;;
	
	public int insertMember(V3_MemberVO vo) {
		return sqlsession.insert("V3_Member.insertMember", vo);
	}
	
	public int selectMemberLogin(V3_MemberVO vo) {
		return sqlsession.selectOne("V3_Member.selectMemberLogin", vo);
	}

	
}
