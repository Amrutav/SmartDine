package tab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_order")
public class Order {
	@Id
	@GenericGenerator(name="tmo", strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="OrderId")
	private int orderId;
	@Column(name="TableName")
	private String tableName;
	@Column(name="ItemId")
	private int itemId;
	@Column(name="ItemName")
	private String itemName;
	@Column(name="Serving")
	private String serving;
	@JoinColumn(name="Quantity")
	private int quantity;
	@Column(name="SpicyLevel")
	private String spicyLevel;
	@Column(name="Price")
	private double price;
	@Column(name="DateTime")
	private Date dateTime;
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	public String getServing() {
		return serving;
	}
	public void setServing(String serving) {
		this.serving = serving;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSpicyLevel() {
		return spicyLevel;
	}
	public void setSpicyLevel(String spicyLevel) {
		this.spicyLevel = spicyLevel;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
