package com.kte.sts4.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.kte.sts4.vo.V8_File;

public interface V8_FileDAO {
	
	@Update("UPDATE v8_file SET text=#{vo.text}, filename=#{vo.filename}, file=#{vo.file, jdbcType=BLOB} WHERE no=#{vo.no}")
	public int updateFile(@Param("vo") V8_File vo);
	
	@Update("UPDATE v8_file SET text=#{vo.text} WHERE no=#{vo.no}")
	public int updateFileNull(@Param("vo") V8_File vo);
	
	@Insert("INSERT INTO v8_file(text, file, filename, date1) VALUES(#{vo.text}, #{vo.file, jdbcType=BLOB}, #{vo.filename}, NOW())")
	public int insertFile(@Param("vo") V8_File vo);
	
	@Select("SELECT no, text, filename, date1 FROM v8_file")
	public List<V8_File> selectFileList();
	
	@Results({ @Result(property = "file", column = "file", jdbcType = JdbcType.BLOB) })
	@Select({ "SELECT file, filename FROM V8_FILE WHERE no=#{vo.no}" })
	public V8_File selectFileOne(@Param("vo") V8_File vo);
	
	@Delete("DELETE FROM v8_file WHERE no=#{no}")
	public int deleteFile(@Param("no") int no);
}
