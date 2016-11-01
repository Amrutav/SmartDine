package tab.entity;

import javax.persistence.CascadeType;
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
	@Column(name="ItemType")
	private String itemType;
	@Column(name="ItemDesc")
	private String itemDesc;
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CatagoryId")
	private Category catagory;
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
	public Category getCatagory() {
		return catagory;
	}
	public void setCatagory(Category catagory) {
		this.catagory = catagory;
	}
	
	
}
