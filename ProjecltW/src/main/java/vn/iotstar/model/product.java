package vn.iotstar.model;

import java.sql.Date;

public class product {
	private int productid;
	private int categoryid;
	private String productname;
	private String description;
	private String image;
	private double price;
	private Date createdDate;
	private String createby;
	private int sold;
	public product() {
		super();
	}
	public product(int productid, int categoryid, String productname, String description, String image, double price,
			Date createdDate, String createby, int sold) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.productname = productname;
		this.description = description;
		this.image = image;
		this.price = price;
		this.createdDate = createdDate;
		this.createby = createby;
		this.sold = sold;
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
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	@Override
	public String toString() {
		return "product [productid=" + productid + ", categoryid=" + categoryid + ", productname=" + productname
				+ ", description=" + description + ", image=" + image + ", price=" + price + ", createdDate="
				+ createdDate + ", createby=" + createby + ", sold=" + sold + "]";
	}
	
	
}
