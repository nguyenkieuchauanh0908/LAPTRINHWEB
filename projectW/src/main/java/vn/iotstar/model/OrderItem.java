package vn.iotstar.model;

import java.sql.Date;

public class OrderItem {
	private int _id;
	private int orderId;
	private int productId;
	private int count_SP;
	private Date createdAt;
	private Date updatedAt;
	private Product product;

	
	public OrderItem() {
		super();
	}
	public OrderItem(int _id, int orderId, int productId, int count_SP, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.productId = productId;
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
		return "OrderItem [_id=" + _id + ", orderId=" + orderId + ", productId=" + productId + ", count_SP=" + count_SP
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", product=" + product + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
