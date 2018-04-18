package com.kte.sts4.vo;

public class V9_Seller {
	private String cr_number=null, name=null, tel=null, addr=null, date=null, code=null;

	private String bc_name = null;
	
	
	
	public String getBc_name() {
		return bc_name;
	}

	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}

	public String getCr_number() {
		return cr_number;
	}

	public void setCr_number(String cr_number) {
		this.cr_number = cr_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "V9_Seller [cr_number=" + cr_number + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", code="
				+ code + "]";
	}

	
	
}
