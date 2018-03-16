package com.kte.mvc.vo;

import java.util.List;

public class V3_Member {
	private String email = null;
	private String pw = null;
	private String name = null;
	private String phone = null;
	private String date1 = null;

	private String pw1 = null;
	
	private String post_code = null;
	private String addr1 = null;
	private String addr2 = null;
	
	private int no = 0;
	//{"사회", "과학", "문화"}
	private List<String> ns_name = null;
	//사회, 과학, 문화
	private String ns_name_str = null;
	private String[] ns_name_item = {"경제", "문학", "인문", "사회", "과학"};

	
	
	public String getPw1() {
		return pw1;
	}
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	public String getNs_name_str() {
		return ns_name_str;
	}
	public void setNs_name_str(String ns_name_str) {
		this.ns_name_str = ns_name_str;
	}
	public String[] getNs_name_item() {
		return ns_name_item;
	}
	public void setNs_name_item(String[] ns_name_item) {
		this.ns_name_item = ns_name_item;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public List<String> getNs_name() {
		return ns_name;
	}
	public void setNs_name(List<String> ns_name) {
		this.ns_name = ns_name;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	
}
