import java.sql.SQLException;
import java.util.List;


public class Cart {
	private List<Goods> goodsList;
	
	//删除商品
	public void deleteGoods(int id, int number) throws SQLException{
		DB my_db = new DB();
		int purchaseNumber = (int) my_db.search(id,2,"cart");//获取购物车中该物品的购买数量
		
		//当删除数量等于购物车中的购买数量时，将数据库中cart表对应数据删除，同时删除购物列表中的数据
		if(number==purchaseNumber){
			my_db.delete("cart",Integer.toString(id));
			for(int i=0;i<goodsList.size();i++){   
	            if(Integer.toString(goodsList.get(i).getID()).equals(id)){   
	                goodsList.remove(i);   
	            }   
	        }   
		}
		
		//减少购买数量，更新数据库cart表中的购买数量以及购物列表中的购买数量
		else{
			int currentNumber=purchaseNumber-number;
			for(int i=0;i<goodsList.size();i++){   
	            if(Integer.toString(goodsList.get(i).getID()).equals(id)){   
	                goodsList.get(i).setPurchaseNumber(currentNumber);   
	            }   
	        }   
			my_db.update(2,currentNumber,"update cart set purchasenumber=? where id="+Integer.toString(id));
		}
	}
	
	//添加商品
	public void addGoods(int id, int purchaseNumber) throws SQLException{
		DB my_db = new DB();
		int numberAvailable = (int) my_db.search(id, 5, "goods");//获取商品库存数量
		
		//当购买数量小于商品库存数量时，在购物列表和数据库cart表添加数据
		if(purchaseNumber<numberAvailable){
			Goods goods = new Goods(id,purchaseNumber);
			goodsList.add(goods);
			Object[] data = {id,purchaseNumber};
			my_db.insert("insert into cart(id,purchasenumber) values(?,?)", data);
		}
		
		//当购买数量超过库存时，输出提示信息
		else
			System.out.println("商品库存不足");
	}
	
	//获得购物列表
	public List<Goods> getGoodsList(){
		return goodsList;	
	}
}
