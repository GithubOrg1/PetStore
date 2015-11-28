import java.sql.SQLException;


public class Customer {
	private String name;
	private int account;
	private int uid;
	private String phoneNumber;
	//private Cart cart;
	private Order order;
	
	
	public String getName(){
		return name;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;	
	}
	
	public int getAccount(){
		return account;	
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber=phoneNumber;
	}
	
	public void setAccount(int account){
		this.account=account;
	}
	/*
	public Cart getCart(){
		return cart;	
	}*/
	
	public Order getOrder(){
		return order;	
	}

	public int getPid() {
		return uid;
	}

	public void setPid(int pid) {
		this.uid = pid;
	}
	
	public Payment pay() throws SQLException{
		float totalPrice=new OrderCalc().getTotalPrice();
		Payment payment = new Payment(totalPrice,uid);
		DB my_db=new DB();
		Object[] data=new Object[2];
		data[0]=totalPrice;
		data[1]=uid;
		my_db.insert("insert into payment(totalprice,pid) values(?,?)", data);
		for(int i=0;i<order.getOrderList().size();i++){
			int purchaseNumber = order.getOrderList().get(i).getPurchaseNumber();
			int id =order.getOrderList().get(i).getId();
			int numberAvailable = (int) my_db.search(id, 5, "goods");
			int remainingNumber = numberAvailable-purchaseNumber;
			my_db.update(5, remainingNumber, "update goods set numberavailable=? where id="+Integer.toString(id));
			my_db.update(6, 0, "update goods set numberavailable=? where id="+Integer.toString(id));
			my_db.delete("cart", Integer.toString(id));
		}
		return payment;
	}
}
