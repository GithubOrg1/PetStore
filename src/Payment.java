

public class Payment {
	
	private float totalPrice;
	private int pid;

	public Payment(float totalPrice,int pid){
		this.totalPrice=totalPrice;
		this.pid=pid;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getNumber() {
		return pid;
	}

	public void setNumber(int pid) {
		this.pid = pid;
	}
}
