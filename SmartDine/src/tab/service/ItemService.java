package tab.service;

import java.util.List;

import tab.entity.Item;
import tab.entity.ItemBean;
import tab.entity.Order;

public interface ItemService {

	public boolean addItem(Item item)throws Exception;

	List<Item> getItemList()throws Exception;

	public boolean deleteItem(Item item)throws Exception;

	public List<ItemBean> getItemListByCategoryId(int categoryId,int subCategoryId)throws Exception;

	public Item validateItem(String itemName)throws Exception;

	public List<Item> getItemById(int itemId)throws Exception;

	public boolean updateItem(Item item)throws Exception;


}
