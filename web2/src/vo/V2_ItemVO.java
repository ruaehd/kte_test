package vo;

public class V2_ItemVO {
	private int no = 0;
	private String name = null;
	private int price = 0;
	private String price1 = null;
	private int qty = 0;
	private String date1 = null;
	
	
	
	//생성자를 임의로 생성하면 default생성자 반드시 생성
	public V2_ItemVO(int no, String name, int price, int qty) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	
	//defalut생성자
	public V2_ItemVO() {
		
	}
	
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
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
