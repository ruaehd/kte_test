package com.kte.mvc.vo;

public class V6_Member_chk {
	public int memc_no = 0;
	private String mem_id = null;
	private String memc_title = null;
	private boolean memc_title1 = false;
	private String memc_date = null;
	
	
	public boolean isMemc_title1() {
		return memc_title1;
	}
	public void setMemc_title1(boolean memc_title1) {
		this.memc_title1 = memc_title1;
	}
	public int getMemc_no() {
		return memc_no;
	}
	public void setMemc_no(int memc_no) {
		this.memc_no = memc_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMemc_title() {
		return memc_title;
	}
	public void setMemc_title(String memc_title) {
		this.memc_title = memc_title;
	}
	public String getMemc_date() {
		return memc_date;
	}
	public void setMemc_date(String memc_date) {
		this.memc_date = memc_date;
	}
	
	
}
