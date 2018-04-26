package com.kte.sts4.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemDAOImpl implements ItemDAO{

	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession = null;
	
	@Override
	public List<Object> selectItemList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("V9_Item.selectItemList");
	}

}
