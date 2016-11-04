package tab.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
			itemList=criteria.list();
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
	public List<ItemBean> getItemListByCategoryId(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<ItemBean> getItemListByCategoryId = new ArrayList<ItemBean>();
		List temp=null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT itemId,itemName,itemType,itemDesc,itemAvailability,itemSpicyLevel,priceFull,priceHalf,catagoryId FROM tbl_food_item WHERE CatagoryId = "+categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			temp=query.list();
			if(temp!=null && temp.size()!=0){
				for(Object obj:temp){
					Object[] item=(Object[]) obj;
					ItemBean bean=new ItemBean();
					bean.setItemId((int) item[0]);
					bean.setItemName((String) item[1]);
					bean.setItemType((String) item[2]);
					bean.setItemDesc((String) item[3]);
					bean.setItemAvailability((String) item[4]);
					bean.setItemSpicyLevel((String) item[5]);
					bean.setPriceFull((double) item[6]);
					bean.setPriceHalf((double) item[7]);
					bean.setCategoryId((int) item[8]);
					getItemListByCategoryId.add(bean);
					
				}
				
			}
	
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getItemListByCategoryId;
	}

}
