package com.kte.sts4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kte.sts4.vo.V9_Seller;

public interface V9_SellerDAO {

	@Update({"UPDATE v9_seller SET name=#{vo.name},",
		" tel=#{vo.tel}, addr=#{vo.addr}, code=#{vo.code} ",
		" WHERE cr_number=#{vo.cr_number}"})
	public int updateSeller(@Param("vo")V9_Seller vo);


	@Delete({"DELETE FROM v9_seller WHERE cr_number=#{cr_number}"})
	public int deleteSeller(@Param("cr_number")String cr_number);
	
	
	//판매자 등록
	@Options(useGeneratedKeys=false)
	@Insert({"INSERT INTO v9_seller(cr_number, name, tel,",
		"addr, code, date) VALUES(#{vo.cr_number}, #{vo.name},",
		"#{vo.tel}, #{vo.addr}, #{vo.code}, NOW())"})
	public int insertSeller(@Param("vo")V9_Seller vo);
	
	//판매자 목록 - 조건없음
	@Select({"SELECT s.cr_number, s.name, s.tel, s.addr, ",
		"s.date, bc.name bc_name, bc.code ",
		"FROM v9_seller s, v9_business_conditions bc ",
		"WHERE s.code = bc.code LIMIT #{page}, 10"})
	public List<V9_Seller> selectSeller1(@Param("page")int page);
	
	//판매자 목록 - 조건있음
	@Select({"SELECT s.cr_number, s.name, s.tel, s.addr, ",
		"s.date, bc.name bc_name, bc.code ",
		"FROM v9_seller s, v9_business_conditions bc ",
		"WHERE s.code = bc.code AND bc.code=#{sel_bc} LIMIT #{page}, 10"})
	public List<V9_Seller> selectSeller(@Param("page")int page, 
			@Param("sel_bc") String sel_bc);

	// 전체 판매자 수
	@Select({"SELECT COUNT(*) FROM v9_seller"})
	public int selectSellerCount1();
	
	//조건 있음
	@Select({"SELECT COUNT(*) FROM v9_seller WHERE code=#{sel_bc}"})
	public int selectSellerCount(@Param("sel_bc") String sel_bc);
}
