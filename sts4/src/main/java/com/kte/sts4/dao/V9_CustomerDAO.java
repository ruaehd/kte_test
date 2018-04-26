package com.kte.sts4.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kte.sts4.vo.V9_Member;

public interface V9_CustomerDAO {

	@Select({ "SELECT COUNT(*) FROM v9_member WHERE id=#{id}" })
	public int selectIDCheck(@Param("id") String id);

	@Options(useGeneratedKeys = false)
	@Insert({ "INSERT INTO v9_member(id, pw, name, date)", " VALUES(#{vo.id}, SHA1(#{vo.pw}), #{vo.name}, NOW())" })
	public int insertCustomer(@Param("vo") V9_Member vo);
	
	@Select({"SELECT * FROM v9_member WHERE id=#{vo.id} AND pw=SHA1(#{vo.pw})"})
	public V9_Member selectLogin( @Param("vo") V9_Member vo );

}
