package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V3_Item;

@Service
public class V3_ItemXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	
	public int insertItem1(V3_Item vo) {
		//현재 코드번호를 읽음
		String lastCode = sqlsession.selectOne("V3_Item.selectLastSequence");
		
		//코드번호를 a-b 더하기 100000000x로 만듬
		vo.setCode( vo.getCode()+lastCode);
		
		//mapper를 순차적으로 2번 호출
		sqlsession.insert("V3_Item.insertItem1", vo);
		return sqlsession.insert("V3_Item.insertItem2", vo);
	}
	
	public void insertItem3(V3_Item vo){
		sqlsession.selectOne("V3_Item.insertItem3", vo);
	}
	
	public List<V3_Item> selectItemList(){
		return sqlsession.selectList("V3_Item.selectItemList");
	}
	
	public V3_Item selectBlobImg(String code) {
		return sqlsession.selectOne("V3_Item.selectBlobImg", code);
	}
	
	public V3_Item selectItemOne(String code) {
		return sqlsession.selectOne("V3_Item.selectItemOne", code);
	}
	
	public V3_Item selectBlobImg1(V3_Item obj) {
		return sqlsession.selectOne("V3_Item.selectBlobImg1", obj);
	}

}