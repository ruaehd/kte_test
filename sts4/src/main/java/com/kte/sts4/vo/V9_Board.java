package com.kte.sts4.vo;

public class V9_Board {
	private int no = 0, hit=0;
	private String title=null, content=null, writer=null, date=null;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "V9_Board [no=" + no + ", hit=" + hit + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", date=" + date + "]";
	}
	
	
}
