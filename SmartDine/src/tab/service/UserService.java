package tab.service;

import org.hibernate.HibernateException;

import tab.entity.User;

public interface UserService {

	public User getAuthenticateUser(User user)throws Exception, HibernateException;

	public int getMaxId()throws Exception;

	public boolean addUser(User user)throws Exception;

}
