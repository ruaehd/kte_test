package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V6_ItemA;
import com.kte.mvc.vo.V6_ItemB;
import com.kte.mvc.vo.V6_ItemC;

@Service
public class V6_ItemDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V6_ItemA> selectItemAList(){
		return sqlsession.selectList("V6_Item.selectItemAList");
	}

	public List<V6_ItemB> selectItemBList(int code){
		return sqlsession.selectList("V6_Item.selectItemBList", code);
	}
	
	public List<V6_ItemC> selectItemCList(int code){
		return sqlsession.selectList("V6_Item.selectItemCList", code);
	}
}
