package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V6_BoardReply;

@Service
public class V6_BoardReplyDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public int insertBoardReply(V6_BoardReply vo) {
		return sqlsession.insert("V6_BoardReply.insertBoardReply", vo);
	}
	
	public V6_BoardReply selectBoardReply(int rep_no) {
		return sqlsession.selectOne("V6_BoardReply.selectBoardReply", rep_no);
	}
	
	public List<V6_BoardReply> selectBoardReplyList(int brd_no) {
		return sqlsession.selectList("V6_BoardReply.selectBoardReplyList", brd_no);
	}

}
