package com.kte.sts4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kte.sts4.vo.V9_BusinessConditions;

public interface V9_BusinessConditionsDAO {
	@Select("SELECT code, name FROM v9_business_conditions")
	public List<V9_BusinessConditions> seectBCList();
}
