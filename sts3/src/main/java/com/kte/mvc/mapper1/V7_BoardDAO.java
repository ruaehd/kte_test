package com.kte.mvc.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.kte.mvc.vo.V7_Board;
import com.kte.mvc.vo.V7_BoardCode;
import com.kte.mvc.vo.V7_BoardImg;

public interface V7_BoardDAO {
	
	@Select("SELECT * FROM V7_BOARD_CODE")
	public List<V7_BoardCode> selectBoardCode();
	
	@Select("SELECT NVL(MAX(brd_no),0) FROM V7_BOARD")
	public Integer selectBoardMaxNo();
	
	@Select("INSERT ALL "
			+ "INTO V7_BOARD(BRD_NO, BRD_TITLE, BRD_CONTENT, BRD_HIT, BRD_DATE, BRD_CD_NO, MEM_ID)" 
			+ "VALUES(#{vo.brd_no}, #{vo.brd_title}, #{vo.brd_content}, #{vo.brd_hit}, SYSDATE, #{vo.brd_cd_no}, #{vo.mem_id})"
			+ "INTO V7_BOARD_IMG(BRD_NO, BRD_IMG_1, BRD_IMG_2, BRD_IMG_3, BRD_IMG_DATE)" 
			+ "VALUES(#{vo1.brd_no}, #{vo1.brd_img_1, jdbcType=BLOB}, #{vo1.brd_img_2, jdbcType=BLOB}, #{vo1.brd_img_3, jdbcType=BLOB}, SYSDATE)"
			+ "SELECT * FROM DUAL")
	public void insertBoard(@Param("vo") V7_Board vo, @Param("vo1") V7_BoardImg imgVO);
	
	@Select("SELECT * FROM V7_BOARD WHERE BRD_CD_NO=#{brd_cd_no} ORDER BY BRD_NO DESC")
	public List<V7_Board> selectBoardList(@Param("brd_cd_no") int no);
	
	@Results({
		@Result(property="brd_img_1", column="brd_img_1", jdbcType=JdbcType.BLOB), 
		@Result(property="brd_img_2", column="brd_img_2", jdbcType=JdbcType.BLOB), 
		@Result(property="brd_img_3", column="brd_img_3", jdbcType=JdbcType.BLOB)
		})
	@Select("SELECT * FROM V7_BOARD_IMG WHERE BRD_NO = #{no}")
	public V7_BoardImg selectBoardImg(@Param("no") int no);
}
