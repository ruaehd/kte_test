package com.kte.sts4.dao;

import java.util.List;
import java.util.Map;

import com.kte.sts4.vo.V9_Board;

public interface BoardDAO {
	public int selectBoardPrev(Map<String, Object> map);
	public int selectBoardNext(Map<String, Object> map);
	public V9_Board selectBoardOne(int no);
	public List<V9_Board> selectBoardList();
	public int insertBoard(V9_Board vo);
	
	
}
