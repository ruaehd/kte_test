package com.kte.mvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kte.mvc.vo.V5_CourseApplication;
import com.kte.mvc.vo.V5_Department;
import com.kte.mvc.vo.V5_Subject;

@Service
public class V5_CurAppXMLDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlsession = null;
	
	public List<V5_Department> selectDeptList(){
		return sqlsession.selectList("V5_CurApp.selectDeptList");
	}
	
	public List<V5_Subject> selectSjctList(){
		return sqlsession.selectList("V5_CurApp.selectSjctList");
	}
	
	public int insertCurApp(V5_CourseApplication vo) {
		return sqlsession.insert("V5_CurApp.insertCurApp", vo);
	}
	
	public List<V5_CourseApplication> selectCurAppList(String id){
		return sqlsession.selectList("V5_CurApp.selectCurAppList", id);
	}
	
	public int delectCurApp(String code) {
		return sqlsession.update("V5_CurApp.delectCurApp", code);
	}
}
