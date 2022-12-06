package vn.iotstar.model;

import java.sql.Date;

public class Product {
	private int _id;
	private String name;
	private String slug;
	private String description;
	private Float price;
	private Float promotionalPrice;
	private int quantity;
	private int sold;
	private byte isActive;
	private byte isSelling;
	private String image;
	private int categoryId;
	private int storeId;
	private byte isDeteled;
	private int rating;
	private Date createdAt;
	private Date updatedAt;
	public Product() {
		super();
	}
	public Product(int _id, String name, String slug, String description, Float price, Float promotionalPrice,
			int quantity, int sold, byte isActive, byte isSelling, int categoryId, int storeId, byte isDeteled,
			int rating, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.isDeteled = isDeteled;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getPromotionalPrice() {
		return promotionalPrice;
	}
	public void setPromotionalPrice(Float promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public byte getIsActive() {
		return isActive;
	}
	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}
	public byte getIsSelling() {
		return isSelling;
	}
	public void setIsSelling(byte isSelling) {
		this.isSelling = isSelling;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public byte getIsDeteled() {
		return isDeteled;
	}
	public void setIsDeteled(byte isDeteled) {
		this.isDeteled = isDeteled;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
		return "Product [_id=" + _id + ", name=" + name + ", slug=" + slug + ", description=" + description + ", price="
				+ price + ", promotionalPrice=" + promotionalPrice + ", quantity=" + quantity + ", sold=" + sold
				+ ", isActive=" + isActive + ", isSelling=" + isSelling + ", categoryId=" + categoryId + ", storeId="
				+ storeId + ", isDeteled=" + isDeteled + ", rating=" + rating + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
