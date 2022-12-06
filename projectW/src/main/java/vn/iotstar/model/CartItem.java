package vn.iotstar.model;

import java.sql.Date;

public class CartItem {
	private int _id;
	private int cartId;
	private Product product;
	private int count_SP;
	private Date createdAt;
	private Date updatedAt;
	public CartItem() {
		super();
	}
	public CartItem(int _id, int cartId, Product product, int count_SP, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.cartId = cartId;
		this.product = product;
		this.count_SP = count_SP;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount_SP() {
		return count_SP;
	}
	public void setCount_SP(int count_SP) {
		this.count_SP = count_SP;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "CartItem [_id=" + _id + ", cartId=" + cartId + ", product=" + product + ", count_SP=" + count_SP
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
