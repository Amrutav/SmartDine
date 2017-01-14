package tab.dao;

import org.hibernate.HibernateException;

import tab.entity.User;

public interface UserDao {

	public User getAuthenticUser(User user)throws Exception, HibernateException;

	public int getMaxId()throws Exception;

	public boolean addUser(User user)throws Exception;

}
