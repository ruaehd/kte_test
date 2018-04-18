package com.kte.sts4.vo;

public class V2_Item {
	private int no = 0;
	private String name = null;
	private int price = 0;
	private int qty = 0;
	private String date1 = null;
	
	
	
	public V2_Item(int no, String name, int price, int qty) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public V2_Item() {
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	
}
