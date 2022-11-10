package vn.iotstar.model;

public class billDetail {
	private int billDetailid;
	private int billid;
	private int productid;
	private int userid;
	private double amount;
	private String description;
	private int quantity;
	public billDetail() {
		super();
	}
	public billDetail(int billDetailid, int billid, int productid, int userid, double amount, String description,
			int quantity) {
		super();
		this.billDetailid = billDetailid;
		this.billid = billid;
		this.productid = productid;
		this.userid = userid;
		this.amount = amount;
		this.description = description;
		this.quantity = quantity;
	}
	public int getBillDetailid() {
		return billDetailid;
	}
	public void setBillDetailid(int billDetailid) {
		this.billDetailid = billDetailid;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "billDetail [billDetailid=" + billDetailid + ", billid=" + billid + ", productid=" + productid
				+ ", userid=" + userid + ", amount=" + amount + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
	
}
