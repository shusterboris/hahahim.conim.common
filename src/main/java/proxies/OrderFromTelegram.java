package proxies;

public class OrderFromTelegram {
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBundle() {
		return bundle;
	}

	public float getQuantity() {
		return quantity;
	}

	public float getCost() {
		return cost;
	}

	private long id;
	private long bundle;
	private float quantity;
	private float cost;
	private float price;

	public float getPrice() {
		return price;
	}

}
