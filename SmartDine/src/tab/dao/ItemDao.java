package tab.dao;

import java.util.List;

import org.hibernate.HibernateException;

import tab.entity.Item;
import tab.entity.ItemBean;

public interface ItemDao {

	public boolean addItem(Item item)throws Exception;

	public List<Item> getItemList()throws Exception;

	public boolean deleteItem(Item item)throws Exception, HibernateException;

	public List<ItemBean> getItemListByCategoryId(int categoryId)throws Exception;

}
