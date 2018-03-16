package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_Cart;


@Service
public class V3_CartXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public int insertCart(V3_Cart vo) {
		return sqlsession.insert("V3_Cart.insertCart", vo);
	}
	
	public List<V3_Cart> selectCartList(String code){
		return sqlsession.selectList("V3_Cart.selectCartList", code);
	}
	
}
