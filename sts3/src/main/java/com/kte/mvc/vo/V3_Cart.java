package com.kte.mvc.vo;

public class V3_Cart {
	private int cart_no = 0;
	private String cart_item = null;
	private String cart_user = null;
	private int cart_cnt = 0;
	private String cart_date = null;
	
	private String name = null;
	private int price = 0;
	
	
	
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
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getCart_item() {
		return cart_item;
	}
	public void setCart_item(String cart_item) {
		this.cart_item = cart_item;
	}
	public String getCart_user() {
		return cart_user;
	}
	public void setCart_user(String cart_user) {
		this.cart_user = cart_user;
	}
	public int getCart_cnt() {
		return cart_cnt;
	}
	public void setCart_cnt(int cart_cnt) {
		this.cart_cnt = cart_cnt;
	}
	public String getCart_date() {
		return cart_date;
	}
	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}
	
	
}
