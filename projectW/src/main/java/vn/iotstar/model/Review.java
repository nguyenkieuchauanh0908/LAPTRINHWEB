package vn.iotstar.model;

import java.sql.Date;

public class Review {
	private int _id;
	private int userId;
	private int productId;
	private int storeId;
	private int orderId;
	private String content;
	private int stars;
	private Date createdAt;
	private Date updatedAt;
	private User user;
	public Review() {
		super();
	}
	public Review(int _id, int userId, int productId, int storeId, int orderId, String content, int stars,
			Date createdAt, Date updatedAt, User user) {
		super();
		this._id = _id;
		this.userId = userId;
		this.productId = productId;
		this.storeId = storeId;
		this.orderId = orderId;
		this.content = content;
		this.stars = stars;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Review [_id=" + _id + ", userId=" + userId + ", productId=" + productId + ", storeId=" + storeId
				+ ", orderId=" + orderId + ", content=" + content + ", stars=" + stars + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", user=" + user + "]";
	}
	
}
