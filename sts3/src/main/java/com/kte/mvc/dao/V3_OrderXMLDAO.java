package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_Order;

@Service
public class V3_OrderXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public int insertOrder(V3_Order vo) {
		return sqlsession.insert("V3_Order.insertOrder", vo);
	}
	
	public List<V3_Order> selectOrderList(String email){
		return sqlsession.selectList("V3_Order.selectOrderList", email);
	}
	
}
