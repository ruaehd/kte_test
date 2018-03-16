package com.kte.mvc.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kte.mvc.vo.V5_CourseApplication;
import com.kte.mvc.vo.V5_Department;
import com.kte.mvc.vo.V5_Student;
import com.kte.mvc.vo.V5_Subject;

public interface V5_StudentDAO {
	
	//@Options(useGeneratedKeys=false)	//자동증가된 id값 사용하지 않겠다
	@Options(useGeneratedKeys=true, keyProperty = "vo.std_id")	//자동증가된 id값이 필요하니 내가보낸 vo의 std_id변수에 넣겠다
	@Insert("INSERT INTO V5_STUDENT(std_id, std_name, std_tel, std_date) VALUES(#{vo.std_id}, #{vo.std_name}, #{vo.std_tel}, SYSDATE)")
	public int insertStudent(@Param("vo") V5_Student vo);
	
	@Select("SELECT * FROM V5_STUDENT")
	public List<V5_Student> selectStudentList();
	
	@Select("SELECT * FROM V5_STUDENT WHERE STD_ID=#{vo.std_id} AND STD_NAME=#{vo.std_name}")
	public V5_Student loginStudent(@Param("vo") V5_Student vo);
	
	@Select("SELECT NVL(MAX(CRS_CODE), 0) CRS_CODE FROM V5_COURSE_APPLICATION")
	public int selectMaxCrscode();
	
	@Select("SELECT * FROM V5_DEPARTMENT")
	public List<V5_Department> selectDepartmentList();
	
	@Select("SELECT * FROM V5_SUBJECT")
	public List<V5_Subject> selectSubjectList();
	
	@Options(useGeneratedKeys=false)
	//@Options(useGeneratedKeys=true, keyProperty = "vo.std_id")	//int로 못받음
	@Insert("INSERT INTO V5_COURSE_APPLICATION (crs_code, dept_cd, sjct_cd, std_id, crs_date) VALUES(#{vo.crs_code}, #{vo.dept_cd}, #{vo.sjct_cd}, #{vo.std_id}, SYSDATE)")
	public int insertCurApp(@Param("vo") V5_CourseApplication vo);
	
}
