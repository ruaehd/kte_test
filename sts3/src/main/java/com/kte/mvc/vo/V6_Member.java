package com.kte.mvc.vo;

import java.util.List;

public class V6_Member {
	private String mem_id = null;
	private String mem_pw = null;
	private String mem_name = null;
	private String mem_date = null;
	private List<V6_Member_chk> list = null;
	
	private String tmp_id = null;
	private String remote_addr = null;

	
	
	public String getTmp_id() {
		return tmp_id;
	}
	public void setTmp_id(String tmp_id) {
		this.tmp_id = tmp_id;
	}
	public String getRemote_addr() {
		return remote_addr;
	}
	public void setRemote_addr(String remote_addr) {
		this.remote_addr = remote_addr;
	}
	public List<V6_Member_chk> getList() {
		return list;
	}
	public void setList(List<V6_Member_chk> list) {
		this.list = list;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	
}
