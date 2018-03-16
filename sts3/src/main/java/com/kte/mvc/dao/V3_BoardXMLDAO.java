package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_Board;

@Service
public class V3_BoardXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V3_Board> selectBoardList(){
		return sqlsession.selectList("V3_Board.selectBoardList");
	}
}