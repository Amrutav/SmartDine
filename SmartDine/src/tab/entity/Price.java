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
@Table(name="tbl_food_price")
public class Price {
	
	@Id
	@GenericGenerator(name="tmo",strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="PriceId")
	private int priceId;
	@Column(name="PriceFull")
	private double priceFull;
	@Column(name="PriceHalf")
	private double priceHalf;
	@ManyToOne
	@JoinColumn(name="ItemId")
	private Item item;
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
