package com.kte.sts4.vo;

public class V9_Member {
	private String id = null;
	private String pw = null;
	private String name = null;
	private String date = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "V9_Member [id=" + id + ", pw=" + pw + ", name=" + name + ", date=" + date + "]";
	}
	
	
}
