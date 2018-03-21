package com.kte.mvc.mapper1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kte.mvc.vo.V7_Member;

public interface V7_MemberDAO {
	
	@Options(useGeneratedKeys=false)
	@Insert("INSERT INTO V7_MEMBER VALUES(#{vo.mem_id}, #{vo.mem_pw}, #{vo.mem_name}, #{vo.mem_tel}, #{vo.mem_email}, SYSDATE)")
	public int memberJoin(@Param("vo") V7_Member vo);
	
	@Select("SELECT COUNT(*) FROM V7_MEMBER WHERE mem_id=#{mem_id}")
	public int memberIDCheck(@Param("mem_id") String mem_id);
}
