package tab.service;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.UserDao;
import tab.entity.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User getAuthenticateUser(User user) throws Exception, HibernateException {
		// TODO Auto-generated method stub
		try {
			user = userDao.getAuthenticUser(user);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
