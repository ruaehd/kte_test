package com.kte.mvc.vo;

import java.util.List;

public class V4_BookCheckout {
	
	private int checkout_no = 0;
	private String checkout_start_date = null;
	private String checkout_end_date = null;
	private List<V4_Book> checkout_book_list = null;
	private String checkoutbook_code = null;
	private String checkout_date = null;
	private String member_id = null;
	
	private String book_title = null;
	private String member_name = null;
	
	
	
	
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getCheckoutbook_code() {
		return checkoutbook_code;
	}
	public void setCheckoutbook_code(String checkoutbook_code) {
		this.checkoutbook_code = checkoutbook_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getCheckout_date() {
		return checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}
	public int getCheckout_no() {
		return checkout_no;
	}
	public void setCheckout_no(int checkout_no) {
		this.checkout_no = checkout_no;
	}
	public String getCheckout_start_date() {
		return checkout_start_date;
	}
	public void setCheckout_start_date(String checkout_start_date) {
		this.checkout_start_date = checkout_start_date;
	}
	public String getCheckout_end_date() {
		return checkout_end_date;
	}
	public void setCheckout_end_date(String checkout_end_date) {
		this.checkout_end_date = checkout_end_date;
	}
	public List<V4_Book> getCheckout_book_list() {
		return checkout_book_list;
	}
	public void setCheckout_book_list(List<V4_Book> checkout_book_list) {
		this.checkout_book_list = checkout_book_list;
	}

	
}
