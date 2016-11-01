package tab.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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

}
