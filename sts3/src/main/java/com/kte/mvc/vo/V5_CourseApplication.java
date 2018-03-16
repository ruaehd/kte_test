package com.kte.mvc.vo;

import java.util.List;

public class V5_CourseApplication {
	private int crs_code = 0;
	private String dept_cd = null;
	private String sjct_cd = null;
	private String std_id = null;
	private String crs_date = null;
	private List<V5_Department> dept_list = null;
	private List<V5_Subject> sjct_list = null;
	
	private String dept_name = null;
	private String sjct_name = null;
	private String std_name = null;
	
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getSjct_name() {
		return sjct_name;
	}
	public void setSjct_name(String sjct_name) {
		this.sjct_name = sjct_name;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public int getCrs_code() {
		return crs_code;
	}
	public void setCrs_code(int crs_code) {
		this.crs_code = crs_code;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getSjct_cd() {
		return sjct_cd;
	}
	public void setSjct_cd(String sjct_cd) {
		this.sjct_cd = sjct_cd;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getCrs_date() {
		return crs_date;
	}
	public void setCrs_date(String crs_date) {
		this.crs_date = crs_date;
	}
	public List<V5_Department> getDept_list() {
		return dept_list;
	}
	public void setDept_list(List<V5_Department> dept_list) {
		this.dept_list = dept_list;
	}
	public List<V5_Subject> getSjct_list() {
		return sjct_list;
	}
	public void setSjct_list(List<V5_Subject> sjct_list) {
		this.sjct_list = sjct_list;
	}

}
