package tab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;

	@Override
	public User getAuthenticUser(User user) throws Exception, HibernateException {
		// TODO Auto-generated method stub
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("userName", user.getUserName()));
			criteria.add(Restrictions.eq("password", user.getPassword()));
			criteria.add(Restrictions.eq("userType", user.getUserType()));
			user=(User) criteria.uniqueResult();
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int getMaxId() throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT MAX(loginId) AS loginId FROM tbl_login");
		List<Integer> list = query.list();
		int id = list.get(0);
		System.out.println(id);
		return id;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
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

}
