package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V4_Book;
import com.kte.mvc.vo.V4_BookCheckout;

@Service
public class V4_BookXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V4_Book> selectBookList(){
		return sqlsession.selectList("V4_Book.selectBookList");
	}
	
	public int insertBookCheckout(V4_BookCheckout vo) {
		return sqlsession.insert("V4_Book.insertBookCheckout", vo);
	}
	
	public List<V4_BookCheckout> selectBookCheckoutList(String id) {
		return sqlsession.selectList("V4_Book.selectBookCheckoutList", id);
	}
	
	public int deleteBookCheckoutList(int code) {
		return sqlsession.update("V4_Book.deleteBookCheckoutList", code);
	}
	
}
