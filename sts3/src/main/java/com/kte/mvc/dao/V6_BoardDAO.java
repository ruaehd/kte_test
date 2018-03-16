package com.kte.mvc.dao;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kte.mvc.vo.V6_Board;


@Service
public class V6_BoardDAO {

	@Autowired 
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V6_Board> boardList( ){
		return sqlsession.selectList("V6_Board.selectBoardList");
	}
	
	public int selectLastNo() {
		return sqlsession.selectOne("V6_Board.selectLastNo");
	}

	public int insertBoard(V6_Board vo) {
		return sqlsession.insert("V6_Board.insertBoard", vo);
	}

	public int updateBoardHit(int brd_no) {
		return sqlsession.update("V6_Board.updateBoardHit", brd_no);
	}

	public V6_Board selectBoardOne(int brd_no) {
		return sqlsession.selectOne("V6_Board.selectBoardOne",brd_no);
	}
	
	public int selectBoardPrev(int brd_no) {
		return sqlsession.selectOne("V6_Board.selectBoardPrev",brd_no);
	}
	
	public int selectBoardNext(int brd_no) {
		return sqlsession.selectOne("V6_Board.selectBoardNext",brd_no);
	}
	
	
}
