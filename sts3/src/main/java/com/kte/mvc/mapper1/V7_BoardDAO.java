package com.kte.mvc.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kte.mvc.vo.V7_BoardCode;

public interface V7_BoardDAO {
	
	@Select("SELECT * FROM V7_BOARD_CODE")
	public List<V7_BoardCode> selectBoardCode();
	
	@Select("SELECT NVL(MAX(brd_no),0) FROM V7_BOARD")
	public int selectBoardMaxNo();
}
