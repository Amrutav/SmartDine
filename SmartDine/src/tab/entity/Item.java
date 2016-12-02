package tab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_food_item")
public class Item {
	
	@Id
	@GenericGenerator(name="tmo",strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="ItemId")
	private int itemId;
	@Column(name="ItemName")
	private String itemName;
	@Column(name="ItemImage")
	private String itemImage;
	@Column(name="ItemType")
	private String itemType;
	@Column(name="ItemDesc")
	private String itemDesc;
	@Column(name="ItemSpicyLevel")
	private String itemSpicyLevel;
	@Column(name="PriceFull")
	private double priceFull;
	@Column(name="PriceHalf")
	private double priceHalf;
	@Column(name="ItemAvailability")
	private String itemAvailability;
	public String getItemAvailability() {
		return itemAvailability;
	}
	public void setItemAvailability(String itemAvailability) {
		this.itemAvailability = itemAvailability;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@ManyToOne
	@JoinColumn(name="SubCategoryId")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String getItemSpicyLevel() {
		return itemSpicyLevel;
	}
	public void setItemSpicyLevel(String itemSpicyLevel) {
		this.itemSpicyLevel = itemSpicyLevel;
	}
	public double getPriceFull() {
		return priceFull;
	}
	public void setPriceFull(double priceFull) {
		this.priceFull = priceFull;
	}
	public double getPriceHalf() {
		return priceHalf;
	}
	public void setPriceHalf(double priceHalf) {
		this.priceHalf = priceHalf;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
