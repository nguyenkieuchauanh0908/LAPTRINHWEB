package vn.iotstar.model;

import java.sql.Date;

public class bill {
	private int billid;
	private byte confirmed;
	private byte completed;
	private byte canceled;
	private Date createdDate;
	public bill() {
		super();
	}
	public bill(int billid, byte confirmed, byte completed, byte canceled, Date createdDate) {
		super();
		this.billid = billid;
		this.confirmed = confirmed;
		this.completed = completed;
		this.canceled = canceled;
		this.createdDate = createdDate;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public byte getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(byte confirmed) {
		this.confirmed = confirmed;
	}
	public byte getCompleted() {
		return completed;
	}
	public void setCompleted(byte completed) {
		this.completed = completed;
	}
	public byte getCanceled() {
		return canceled;
	}
	public void setCanceled(byte canceled) {
		this.canceled = canceled;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "bill [billid=" + billid + ", confirmed=" + confirmed + ", completed=" + completed + ", canceled="
				+ canceled + ", createdDate=" + createdDate + "]";
	}
	
}
