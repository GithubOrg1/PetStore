import java.util.List;


public class OrderCalc {
	private float total=0;
	
	public float calOrder(Order order)
	{
		List<OrderItem> orderList;
		orderList=order.getOrderList();
		for(int i=0;i<orderList.size();i++){   
			total+=orderList.get(i).getPurchaseNumber()*orderList.get(i).getPrice();  
		}
		return total;	
	}
	
	public float getTotalPrice(){
		return total;
	}
}
