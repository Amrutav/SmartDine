package tab.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.Order;

public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	@Override
	public boolean takeOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(order);
			transaction.commit();
			boo = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return boo;
	}

	@Override
	public List<Order> getOrderByTableName(String tableName) throws Exception {
		// TODO Auto-generated method stub
		List<Order> orderByTable = new ArrayList<Order>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_order WHERE tableName = '"+tableName+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Order.class);
			orderByTable = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderByTable;
	}

}
