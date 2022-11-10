package vn.iotstar.model;

import java.sql.Date;

public class cart {
	private int cartid;
	private int userid;
	private Date buydate;
	public cart() {
		super();
	}
	public cart(int cartid, int userid, Date buydate) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.buydate = buydate;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	@Override
	public String toString() {
		return "cart [cartid=" + cartid + ", userid=" + userid + ", buydate=" + buydate + "]";
	}
	
}
