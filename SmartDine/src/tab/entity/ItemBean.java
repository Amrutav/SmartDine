package tab.entity;

public class ItemBean {
	
	private int itemId;
	private String itemName;
	private String itemImage;
	private String itemType;
	private String ItemDesc;
	private String itemSpicyLevel;
	private String ItemAvailability;
	private double priceFull;
	private double priceHalf;
	private int categoryId;
	private int subCategoryId;
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
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemAvailability() {
		return ItemAvailability;
	}
	public void setItemAvailability(String itemAvailability) {
		ItemAvailability = itemAvailability;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	
}
