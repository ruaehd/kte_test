package vo;

import java.math.BigInteger;

public class V3_BoardqnaVO {
	private BigInteger no = null;
	private String title = null;
	private String content = null;
	private String writer = null;
	private String password = null;
	private int hit = 0;
	private String date1 = null;
	
	
	public BigInteger getNo() {
		return no;
	}
	public void setNo(BigInteger no) {
		this.no = no;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	
}
