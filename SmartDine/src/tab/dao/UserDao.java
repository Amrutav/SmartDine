package tab.dao;

import org.hibernate.HibernateException;

import tab.entity.User;

public interface UserDao {

	User getAuthenticUser(User user)throws Exception, HibernateException;

}
