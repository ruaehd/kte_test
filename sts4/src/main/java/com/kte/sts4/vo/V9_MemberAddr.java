package com.kte.sts4.vo;

public class V9_MemberAddr {
	private String id = null;
	private String tel = null;
	private String postcode = null;
	private String addr = null;
	private String addr1 = null;
	private String date = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "V9_MemberAddr [id=" + id + ", tel=" + tel + ", postcode=" + postcode + ", addr=" + addr + ", addr1="
				+ addr1 + ", date=" + date + "]";
	}
	
}
