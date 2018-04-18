package com.kte.sts4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kte.sts4.vo.V9_Seller;

public interface V9_SellerDAO {
	
	@Options(useGeneratedKeys=false)
	@Insert("INSERT INTO v9_seller(cr_number, name, tel, addr, date, code) VALUES(#{vo.cr_number}, #{vo.name}, #{vo.tel}, #{vo.addr}, NOW(), #{vo.code})")
	public int insertSeller(@Param("vo") V9_Seller vo);
	
	@Select("SELECT s.cr_number, s.name, s.tel, s.addr, s.date, bc.name bc_name"
			+ " FROM v9_seller s, v9_business_conditions bc"
			+ " WHERE s.code = bc.code")
	public List<V9_Seller> selectSeller();
}
