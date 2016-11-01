package tab.service;

import org.hibernate.HibernateException;

import tab.entity.User;

public interface UserService {

	User getAuthenticateUser(User user)throws Exception, HibernateException;

}
