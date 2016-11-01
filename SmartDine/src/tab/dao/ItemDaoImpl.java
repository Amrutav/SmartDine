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
	public List<Item> getItemListByCategoryId(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<Item> getBoardListbyuserId = new ArrayList<Item>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_food_item WHERE CatagoryId = "+categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Item.class);
			getBoardListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBoardListbyuserId;
	}

}
