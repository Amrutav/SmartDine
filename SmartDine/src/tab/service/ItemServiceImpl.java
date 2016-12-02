package tab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.ItemDao;
import tab.entity.Item;
import tab.entity.ItemBean;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao itemDao;
	
	@Override
	public boolean addItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.addItem(item);
	}

	@Override
	public List<Item> getItemList() throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItemList();
	}

	@Override
	public boolean deleteItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.deleteItem(item);
	}

	@Override
	public List<ItemBean> getItemListByCategoryId(int categoryId,int subCategoryId) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItemListByCategoryId(categoryId,subCategoryId);
	}

	@Override
	public Item validateItem(String itemName) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.validateItem(itemName);
	}

	@Override
	public List<Item> getItemById(int itemId) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.getItemById(itemId);
	}

	@Override
	public boolean updateItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		return itemDao.updateItem(item);
	}

}
