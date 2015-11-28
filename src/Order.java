import java.sql.SQLException;
import java.util.List;


public class Order {
	private List<OrderItem> orderList;
	Object[] data=new Object[4];
	
	public void addOrderItem(OrderItem item) throws SQLException
	{
		DB my_db = new DB();
		orderList.add(item);
		data[0]=item.getId();
		data[1]=item.getName();
		data[2]=item.getPrice();
		data[3]=item.getPurchaseNumber();
		my_db.insert("insert into order(id,name,price,purchasenumber) values(?,?,?,?)", data);
	}
	
	public void addOrderItemFromCart(Cart cart) throws SQLException{
		DB my_db = new DB();
		int length=cart.getGoodsList().size();
		for(int i=0;i<length;i++){
			int id=cart.getGoodsList().get(i).getID();
			int purchaseNumber=cart.getGoodsList().get(i).getPurchaseNumber();
			String name=(String) my_db.search(id, 2, "goods");
			float price=(float) my_db.search(id, 2, "goods");
			OrderItem item=new OrderItem(id,name,price,purchaseNumber);
			orderList.add(item);
			data[0]=id;
			data[1]=name;
			data[2]=price;
			data[3]=purchaseNumber;
			my_db.insert("insert into order(id,name,price,purchasenumber) values(?,?,?,?)", data);
		}
	}
	
	public List<OrderItem> getOrderList(){
		return orderList;	
	}
}
