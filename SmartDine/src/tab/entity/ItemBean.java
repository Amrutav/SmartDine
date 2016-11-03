package tab.entity;

public class ItemBean {
	
	private int itemId;
	private String itemName;
	private String itemType;
	private String ItemDesc;
	private String ItemAvailability;
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
