package com.kte.sts4.vo;

public class V9_Item {
	private int code = 0, price=0, qty=0;
	private String name = null, content=null, date=null, cr_number=null;
	
	@Override
	public String toString() {
		return "V9_Item [code=" + code + ", price=" + price + ", qty=" + qty + ", name=" + name + ", content=" + content
				+ ", date=" + date + ", cr_number=" + cr_number + "]";
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCr_number() {
		return cr_number;
	}
	public void setCr_number(String cr_number) {
		this.cr_number = cr_number;
	}
	
	
}
