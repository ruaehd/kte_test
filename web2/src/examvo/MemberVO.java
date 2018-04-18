package examvo;

public class MemberVO {
	private String userID = null;
	private String name = null;
	private int birthYear = 0;
	private String addr = null;
	private String mobile1 = null;
	private String mobile2 = null;
	private int height = 0;
	private String mDATE = null;
	
	
	
	public MemberVO(String userID, String name, int birthYear, String addr, String mobile1, String mobile2, int height) {
		super();
		this.userID = userID;
		this.name = name;
		this.birthYear = birthYear;
		this.addr = addr;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.height = height;
	}
	
	public MemberVO() {
		
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getmDATE() {
		return mDATE;
	}
	public void setmDATE(String mDATE) {
		this.mDATE = mDATE;
	}
}
