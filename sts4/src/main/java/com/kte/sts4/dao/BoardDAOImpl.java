package com.kte.sts4.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.sts4.vo.V9_Board;

@Service
public class BoardDAOImpl {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession = null;
	
	public int insertBoard(V9_Board vo) {
		System.out.println("DAO : "+vo.toString());
		return sqlSession.insert("V9_Board.insertBoard", vo);
	}
	
	public List<V9_Board> selectBoardList(){
		return sqlSession.selectList("V9_Board.selectBoardList");
	}
	
	public V9_Board selectBoardOne(int no) {
		return sqlSession.selectOne("V9_Board.selectBoardOne", no);
	}
	
	public int selectBoardPrev(Map<String, Object> map) {
		return sqlSession.selectOne("V9_Board.selectBoardPrev", map);
	}
	
	public int selectBoardNext(Map<String, Object> map) {
		return sqlSession.selectOne("V9_Board.selectBoardNext", map);
	}
}
