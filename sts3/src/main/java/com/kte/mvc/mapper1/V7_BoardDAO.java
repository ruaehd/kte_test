package com.kte.mvc.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.type.JdbcType;

import com.kte.mvc.vo.V7_Board;
import com.kte.mvc.vo.V7_BoardCode;
import com.kte.mvc.vo.V7_BoardImg;
import com.kte.mvc.vo.V7_Reply;

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
	//mysql
	//page=1 => SELECT * FROM v7_board WHERE brd_cd_no=1 OREDER BY BRD_NO DESC LIMIT 0, 10
	//page=2 => SELECT * FROM v7_board WHERE brd_cd_no=1 OREDER BY BRD_NO DESC LIMIT 10, 10
	
	@Select("SELECT * FROM" + 
			"      (SELECT brd_no, brd_title, brd_hit, mem_id, brd_date, ROW_NUMBER() OVER (ORDER BY brd_no DESC) rown" + 
			"      FROM V7_BOARD WHERE brd_cd_no = #{code})" + 
			"WHERE rown BETWEEN #{spage} and #{spage}+9")
	public List<V7_Board> selectBoardList1(@Param("code") int no, @Param("spage") int page);
	
	@Select("SELECT * FROM" + 
			"		(SELECT brd_no, brd_title, brd_hit, mem_id, brd_date, ROW_NUMBER() OVER (ORDER BY brd_no DESC) rown" + 
			"		FROM V7_BOARD WHERE brd_cd_no = #{code} " +
			"		AND ${type} LIKE '%' || #{text} || '%' ) "+
			"WHERE rown BETWEEN #{spage} and #{spage}+9")
	public List<V7_Board> selectBoardList2(@Param("code") int no, @Param("spage") int page, @Param("type") String ty, @Param("text") String tx);
	
	//SELECT * FROM 테이블명 WHERE brd_title LIKE '%한글%'
	// MYSQL : WHERE brd_title LIKE CONCAT('%', #{text}, '%')
	//ORACLE : WHERE brd_title LIKE '%' || #{text} || '%'
	
	@Results({
		@Result(property="brd_img_1", column="brd_img_1", jdbcType=JdbcType.BLOB), 
		@Result(property="brd_img_2", column="brd_img_2", jdbcType=JdbcType.BLOB), 
		@Result(property="brd_img_3", column="brd_img_3", jdbcType=JdbcType.BLOB)
		})
	@Select("SELECT * FROM V7_BOARD_IMG WHERE BRD_NO = #{no}")
	public V7_BoardImg selectBoardImg(@Param("no") int no);
	
	@Select("SELECT * FROM V7_BOARD WHERE BRD_NO = #{no}")
	public V7_Board selectBoardOne(@Param("no") int no);
	
	@Select("SELECT COUNT(*) FROM V7_BOARD WHERE brd_cd_no=#{bcn}")
	public int selectBoardTotPage(@Param("bcn") int no);
	
	@Select("SELECT COUNT(*) FROM V7_BOARD WHERE brd_cd_no=#{bcn} AND ${type} LIKE '%' || #{text} || '%' ")
	public int selectBoardTotPage2(@Param("bcn") int no, @Param("type") String ty, @Param("text") String tx);
	
	@Insert("INSERT INTO V7_REPLY(REP_NO, REP_CONTENT, REP_DATE, BRD_NO VALUES(#{maxNo}+1, #{vo.rep_content}, SYSDATE, #{vo.brd_no})")
	@SelectKey(statement = "SELECT NVL(MAX(rep_no),0) maxNo FROM V7_REPLY", keyProperty="maxNo", resultType=Integer.class, before=true)
	public int insertBoardReply(@Param("vo") V7_Reply vo);
}
