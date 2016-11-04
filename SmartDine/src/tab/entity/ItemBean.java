package tab.entity;

public class ItemBean {
	
	private int itemId;
	private String itemName;
	private String itemType;
	private String ItemDesc;
	private String ItemAvailability;
	private String itemSpicyLevel;
	private double priceFull;
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
	private double priceHalf;
	public String getItemAvailability() {
		return ItemAvailability;
	}
	public void setItemAvailability(String itemAvailability) {
		ItemAvailability = itemAvailability;
	}
	private int categoryId;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	
	
}
