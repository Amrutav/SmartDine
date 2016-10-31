package tab.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


import tab.entity.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	Session session = null;
	Transaction transaction = null;

	@Override
	public boolean addCategory(Category category) throws HibernateException {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
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
	public List<Category> getCategoryList() throws Exception {
		// TODO Auto-generated method stub
		List<Category> categoryList= new ArrayList<Category>();
		try{
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			categoryList = criteria.list();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	return categoryList;
	}

	@Override
	public boolean deleteCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(category);
			transaction.commit();
			session.close();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

}