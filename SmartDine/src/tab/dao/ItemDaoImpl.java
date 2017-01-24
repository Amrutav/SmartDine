package tab.dao;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import tab.entity.Item;
import tab.entity.ItemBean;

public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction = null;
	Session session = null;
	
	@Override
	public boolean addItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Item> getItemList() throws Exception {
		// TODO Auto-generated method stub
		List<Item> itemList=new ArrayList<Item>();
		try{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Item.class);
			itemList=criteria.addOrder(Order.desc("itemType")).list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return itemList;
	}

	@Override
	public boolean deleteItem(Item item) throws Exception, HibernateException {
		// TODO Auto-generated method stub
		boolean b=false;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.delete(item);
			transaction.commit();
			session.close();
			b=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<ItemBean> getItemListByCategoryId(int categoryId,int subCategoryId) throws Exception {
		// TODO Auto-generated method stub
		List<ItemBean> getItemList = new ArrayList<ItemBean>();
		List temp=null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			if(categoryId!=0 && subCategoryId!=0){
			String sql = "SELECT itemId,itemName,itemImage,itemType,itemDesc,itemSpicyLevel,itemAvailability,priceFull,priceHalf,categoryId,subCategoryId FROM tbl_food_item WHERE CategoryId = '"+ categoryId +"' AND SubCategoryId='"+ subCategoryId +"'";
			SQLQuery query = session.createSQLQuery(sql);
			temp=query.list();
			if(temp!=null && temp.size()!=0){
				for(Object obj:temp){
					Object[] item=(Object[]) obj;
					ItemBean bean=new ItemBean();
					bean.setItemId((int) item[0]);
					bean.setItemName((String) item[1]);
					bean.setItemImage((String) item[2]);
					bean.setItemType((String) item[3]);
					bean.setItemDesc((String) item[4]);
					bean.setItemSpicyLevel((String) item[5]);
					bean.setItemAvailability((String) item[6]);
					bean.setPriceFull((double) item[7]);
					bean.setPriceHalf((double) item[8]);
					bean.setCategoryId((int) item[9]);
					bean.setSubCategoryId((int) item[10]);
					getItemList.add(bean);
					
				}
				
			}
		}else if(categoryId!=0 && subCategoryId==0){
				
			String sql = "SELECT itemId,itemName,itemImage,itemType,itemDesc,itemSpicyLevel,itemAvailability,priceFull,priceHalf,categoryId,subCategoryId FROM tbl_food_item WHERE CategoryId = '"+ categoryId +"' AND SubCategoryId IS NULL";
			SQLQuery query = session.createSQLQuery(sql);
			temp=query.list();
			if(temp!=null && temp.size()!=0){
				for(Object obj:temp){
					Object[] item=(Object[]) obj;
					ItemBean bean=new ItemBean();
					bean.setItemId((int) item[0]);
					bean.setItemName((String) item[1]);
					bean.setItemImage((String) item[2]);
					bean.setItemType((String) item[3]);
					bean.setItemDesc((String) item[4]);
					bean.setItemSpicyLevel((String) item[5]);
					bean.setItemAvailability((String) item[6]);
					bean.setPriceFull((double) item[7]);
					bean.setPriceHalf((double) item[8]);
					bean.setCategoryId((int) item[9]);
					//bean.setSubCategoryId((int) item[10]);
					getItemList.add(bean);
					
				}
				
			}
			
		}
	} catch (HibernateException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
}
		return getItemList;
	}

	@Override
	public Item validateItem(String itemName) throws Exception {
		// TODO Auto-generated method stub
		Item item=new Item();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(item.getClass());
			criteria.add(Restrictions.eq("itemName", itemName));
			item = (Item) criteria.uniqueResult();
			return item;
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	@Override
	public List<Item> getItemById(int itemId) throws Exception {
		// TODO Auto-generated method stub
		List<Item> getItem = new ArrayList<Item>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_food_item WHERE itemId = "+ itemId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Item.class);
			getItem = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getItem;
	}

	@Override
	public boolean updateItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(item);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
