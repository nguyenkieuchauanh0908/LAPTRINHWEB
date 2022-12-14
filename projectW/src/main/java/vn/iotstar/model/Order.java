package vn.iotstar.model;

import java.sql.Date;

public class Order {
	private int _id;
	private int userId;
	private int storeId;
	private int deliveryId;
	private int commissionId;
	private String address;
	private int phone;
	private String status;
	private byte isPaidBefore;
	private int amountFromUser;
	private int amountFromStore;
	private int amountToGD;
	private int amountToStore;
	private Date createdAt;
	private Date updatedAt;
	private User user;
	public Order() {
		super();
	}
	public Order(int _id, int userId, int storeId, int deliveryId, int commissionId, String address, int phone,
			String status, byte isPaidBefore, int amountFromUser, int amountFromStore, int amountToGD, Date createdAt,
			Date updatedAt) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.commissionId = commissionId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getCommissionId() {
		return commissionId;
	}
	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte getIsPaidBefore() {
		return isPaidBefore;
	}
	public void setIsPaidBefore(byte isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}
	public int getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(int amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public int getAmountFromStore() {
		return amountFromStore;
	}
	public void setAmountFromStore(int amountFromStore) {
		this.amountFromStore = amountFromStore;
	}
	public int getAmountToGD() {
		return amountToGD;
	}
	public void setAmountToGD(int amountToGD) {
		this.amountToGD = amountToGD;
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
public int getAmountToStore() {
		return amountToStore;
	}
	public void setAmountToStore(int amountToStore) {
		this.amountToStore = amountToStore;
	}
	
	@Override
	public String toString() {
		return "Order [_id=" + _id + ", userId=" + userId + ", storeId=" + storeId + ", deliveryId=" + deliveryId
				+ ", commissionId=" + commissionId + ", address=" + address + ", phone=" + phone + ", status=" + status
				+ ", isPaidBefore=" + isPaidBefore + ", amountFromUser=" + amountFromUser + ", amountFromStore="
				+ amountFromStore + ", amountToGD=" + amountToGD + ", amountToStore=" + amountToStore + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", user=" + user + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}