package com.web.khl91.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.khl91.vo.V3_BoardVO;
import com.web.khl91.vo.V3_Board_ImgVO;


@Service
public class V3_BoardDAO {
	@Autowired
	@Resource(name="sqlSession")	//mybatis-context의 마지막bean의 id값을 @Resource의 name값으로 넣음, sqlSession이 1개일 경우는 생략가능함
	private SqlSession sqlsession = null;
	
	public int boardwrite(V3_BoardVO vo) {
		return sqlsession.insert("V3_Board.boardwrite", vo);
	}
	
	public List<V3_BoardVO> boardlist(int page) {
		return sqlsession.selectList("V3_Board.boardlist", page);
	}
	
	public V3_BoardVO boardcontent(int no) {
		return sqlsession.selectOne("V3_Board.boardcontent", no);
	}
	
	public int selectLastNo() {
		return sqlsession.selectOne("V3_Board.selectLastNo");
	}
	
	public int insertBoardImg(V3_Board_ImgVO vo1) {
		return sqlsession.insert("V3_Board.insertBoardImg", vo1);
	}
	
}
