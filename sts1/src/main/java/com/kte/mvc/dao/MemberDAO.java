package com.kte.mvc.dao;

import java.util.List;

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
	
	public List<V3_MemberVO> selectMemberList(){
		return sqlsession.selectList("V3_Member.selectMemberList");
	}
	
	public List<V3_MemberVO> selectMemberList1(){
		return sqlsession.selectList("V3_Member.selectMemberList1");
	}
	
	public int updateMemberChk(V3_MemberVO vo) {
		return sqlsession.update("V3_Member.updateMemberChk", vo);
	}
}
