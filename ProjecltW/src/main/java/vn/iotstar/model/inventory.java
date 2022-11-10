package vn.iotstar.model;

public class inventory {
	private int productid;
	private int categoryid;
	private int pricebuy;
	private int quantity;
	public inventory() {
		super();
	}
	public inventory(int productid, int categoryid, int pricebuy, int quantity) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.pricebuy = pricebuy;
		this.quantity = quantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getPricebuy() {
		return pricebuy;
	}
	public void setPricebuy(int pricebuy) {
		this.pricebuy = pricebuy;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "inventory [productid=" + productid + ", categoryid=" + categoryid + ", pricebuy=" + pricebuy
				+ ", quantity=" + quantity + "]";
	}
	
}
