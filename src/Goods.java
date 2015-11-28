
public class Goods {
	private int numberAvailable;
	private float price;
	private int id;
	private String name;
	private String info;
	private int purchaseNumber;
	
	
	Goods(int id,int purchaseNumber){
		this.id=id;
		this.purchaseNumber=purchaseNumber;
	}
	
	
	public int getNumberAvailable(){
		return numberAvailable;	
	}
	
	public float getPrice(){
		return price;
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;	
	}
	
	public String getInfo(){
		return info;
	}
	
	public int getPurchaseNumber(){
		return purchaseNumber;	
	}
	
	public void setNumberAvailable(int numberAvailable){
		this.numberAvailable=numberAvailable;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public void setPrice(float price){
		this.price=price;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setInfo(String info){
		this.info=info;
	}
	
	public void setPurchaseNumber(int purchaseNumber){
		this.purchaseNumber=purchaseNumber;
	}
	
}
