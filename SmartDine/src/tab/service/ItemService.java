package tab.service;

import java.util.List;

import tab.entity.Item;
import tab.entity.ItemBean;

public interface ItemService {

	public boolean addItem(Item item)throws Exception;

	List<Item> getItemList()throws Exception;

	public boolean deleteItem(Item item)throws Exception;

	public List<ItemBean> getItemListByCategoryId(int categoryId)throws Exception;

}
