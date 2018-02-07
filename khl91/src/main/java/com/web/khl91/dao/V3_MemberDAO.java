package com.web.khl91.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.khl91.vo.V3_MemberVO;

@Service
public class V3_MemberDAO {
	@Autowired
	@Resource(name="sqlSession")	//mybatis-context의 마지막bean의 id값을 @Resource의 name값으로 넣음, sqlSession이 1개일 경우는 생략가능함
	private SqlSession sqlsession = null;
	
	public int join(V3_MemberVO vo) {
		return sqlsession.insert("V3_Member.join", vo);
	}
	public V3_MemberVO login(V3_MemberVO vo) {
		return sqlsession.selectOne("V3_Member.login", vo);
	}
	
}
