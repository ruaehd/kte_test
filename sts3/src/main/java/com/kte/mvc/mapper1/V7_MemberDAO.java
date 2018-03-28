package com.kte.mvc.mapper1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kte.mvc.vo.V7_Member;

public interface V7_MemberDAO {
	
	@Options(useGeneratedKeys=false)
	@Insert("INSERT INTO V7_MEMBER VALUES(#{vo.mem_id}, #{vo.mem_pw}, #{vo.mem_name}, #{vo.mem_tel}, #{vo.mem_email}, SYSDATE)")
	public int memberJoin(@Param("vo") V7_Member vo);
	
	@Select("SELECT COUNT(*) FROM V7_MEMBER WHERE mem_id=#{mem_id}")
	public int memberIDCheck(@Param("mem_id") String mem_id);
	
	@Select("SELECT mem_id, mem_name, mem_tel FROM V7_MEMBER WHERE mem_id=#{vo.mem_id} AND mem_pw=#{vo.mem_pw}")
	public V7_Member memberLogin(@Param("vo") V7_Member vo);
	
	@Select("SELECT * FROM V7_MEMBER WHERE mem_id=#{vo.mem_id}")
	public V7_Member selectMemberOne(@Param("vo") V7_Member vo);
	
	@Options(useGeneratedKeys=false)
	@Update("UPDATE V7_MEMBER SET mem_name=#{vo.mem_name}, mem_tel=#{vo.mem_tel}, mem_email=#{vo.mem_email} WHERE mem_id=#{vo.mem_id}")
	public int updateMemberOne(@Param("vo") V7_Member vo);
	
	
}
