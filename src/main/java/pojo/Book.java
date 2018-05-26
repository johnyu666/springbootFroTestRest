package pojo;

public class Book {
	private Integer id;
	private String bname;
	private float price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String bname, float price) {
		super();
		this.id = id;
		this.bname = bname;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
