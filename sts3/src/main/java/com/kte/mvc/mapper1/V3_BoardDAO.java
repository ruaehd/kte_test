package com.kte.mvc.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kte.mvc.vo.V3_Board;

public interface V3_BoardDAO {
	
	@Select("SELECT no, title, writer, hit, date1 FROM V3_BOARD")
	public List<V3_Board> selectBoardList();
	
	@Insert("INSERT INTO V3_BOARD VALUES(#{vo.no}, #{vo.title}, ...)")
	public int insertBoard(@Param("vo") V3_Board vo);
	
	@Update("UPDATE")
	public int update();
	
	@Delete("DELETE")
	public int delete();
}
