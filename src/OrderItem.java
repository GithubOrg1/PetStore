
public class OrderItem {
	private float price;
	private int id;
	private int purchaseNumber;
	private String name;
	
	public OrderItem(int id, String name, float price, int purchaseNumber)
	{
		this.price=price;
		this.id=id;
		this.purchaseNumber=purchaseNumber;
		this.name=name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
