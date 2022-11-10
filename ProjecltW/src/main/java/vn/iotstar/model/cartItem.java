package vn.iotstar.model;

public class cartItem {
	private int cartItemid;
	private int quantity;
	private float unitprice;
	private int productid;
	private int cartid;
	public cartItem() {
		super();
	}
	public cartItem(int cartItemid, int quantity, float unitprice, int productid, int cartid) {
		super();
		this.cartItemid = cartItemid;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.productid = productid;
		this.cartid = cartid;
	}
	public int getCartItemid() {
		return cartItemid;
	}
	public void setCartItemid(int cartItemid) {
		this.cartItemid = cartItemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	@Override
	public String toString() {
		return "cartItem [cartItemid=" + cartItemid + ", quantity=" + quantity + ", unitprice=" + unitprice
				+ ", productid=" + productid + ", cartid=" + cartid + "]";
	}
	
}
