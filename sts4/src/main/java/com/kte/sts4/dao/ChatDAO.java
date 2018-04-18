package com.kte.sts4.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.sts4.vo.Member;

@Service
public class ChatDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession = null;
	
	public int insertMember(Member vo) {
		return sqlSession.insert("V8_Chat.insertMember", vo);
	}
	
	public int deleteMember(Member vo) {
		return sqlSession.delete("V8_Chat.deleteMember", vo);
	}
	
	public List<Member> selectMemberList(){
		return sqlSession.selectList("V8_Chat.selectMemberList");
	}
}
