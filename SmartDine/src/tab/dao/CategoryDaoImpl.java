package tab.dao;

import java.util.ArrayList;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.Category;
import tab.service.CategoryServiceImpl;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	Session session = null;
	Transaction transaction = null;
	static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

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

	@Override
	public List<Category> categoryListById(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<Category> getBoardListbyuserId = new ArrayList<Category>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_food_category WHERE catagoryId = "+categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Category.class);
			getBoardListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBoardListbyuserId;
	}

	@Override
	public boolean updateCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(category);
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
	public Category validateCategory(String catName) throws Exception {
		// TODO Auto-generated method stub
		Category category=new Category();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(category.getClass());
			criteria.add(Restrictions.eq("categoryName", catName));
			category = (Category) criteria.uniqueResult();
			return category;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return category;
	}

}