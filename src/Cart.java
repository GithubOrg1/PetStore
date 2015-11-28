import java.sql.SQLException;
import java.util.List;


public class Cart {
	private List<Goods> goodsList;
	
	//ɾ����Ʒ
	public void deleteGoods(int id, int number) throws SQLException{
		DB my_db = new DB();
		int purchaseNumber = (int) my_db.search(id,2,"cart");//��ȡ���ﳵ�и���Ʒ�Ĺ�������
		
		//��ɾ���������ڹ��ﳵ�еĹ�������ʱ�������ݿ���cart���Ӧ����ɾ����ͬʱɾ�������б��е�����
		if(number==purchaseNumber){
			my_db.delete("cart",Integer.toString(id));
			for(int i=0;i<goodsList.size();i++){   
	            if(Integer.toString(goodsList.get(i).getID()).equals(id)){   
	                goodsList.remove(i);   
	            }   
	        }   
		}
		
		//���ٹ����������������ݿ�cart���еĹ��������Լ������б��еĹ�������
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
	
	//�����Ʒ
	public void addGoods(int id, int purchaseNumber) throws SQLException{
		DB my_db = new DB();
		int numberAvailable = (int) my_db.search(id, 5, "goods");//��ȡ��Ʒ�������
		
		//����������С����Ʒ�������ʱ���ڹ����б�����ݿ�cart���������
		if(purchaseNumber<numberAvailable){
			Goods goods = new Goods(id,purchaseNumber);
			goodsList.add(goods);
			Object[] data = {id,purchaseNumber};
			my_db.insert("insert into cart(id,purchasenumber) values(?,?)", data);
		}
		
		//�����������������ʱ�������ʾ��Ϣ
		else
			System.out.println("��Ʒ��治��");
	}
	
	//��ù����б�
	public List<Goods> getGoodsList(){
		return goodsList;	
	}
}
