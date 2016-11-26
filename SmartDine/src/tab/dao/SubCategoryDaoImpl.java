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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.SubCategory;
import tab.entity.SubCategoryBean;
import tab.service.SubCategoryServiceImpl;

public class SubCategoryDaoImpl implements SubCategoryDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	Session session = null;
	Transaction transaction = null;
	static final Logger logger = Logger.getLogger(SubCategoryServiceImpl.class);
	
	@Override
	public boolean addSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(subCategory);
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
	public List<SubCategory> getSubCategoryList() throws Exception {
		// TODO Auto-generated method stub
		List<SubCategory> subCategoryList= new ArrayList<SubCategory>();
		try{
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(SubCategory.class);
			subCategoryList = criteria.addOrder(Order.asc("category")).list();
			System.out.println(subCategoryList);
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	return subCategoryList;
	}

	@Override
	public List<SubCategoryBean> getSubCategoryListByCategoryId(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		List<SubCategoryBean> getSubCategoryListByCategoryId = new ArrayList<SubCategoryBean>();
		List temp=null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT subCategoryId,subCategoryName,subCategoryImage,categoryId FROM tbl_food_sub_category WHERE CategoryId = "+categoryId;
			SQLQuery query = session.createSQLQuery(sql);
			temp=query.list();
			if(temp!=null && temp.size()!=0){
				for(Object obj:temp){
					Object[] item=(Object[]) obj;
					SubCategoryBean bean=new SubCategoryBean();
					bean.setSubCategoryId((int) item[0]);
					bean.setSubCategoryName((String) item[1]);
					bean.setSubCategoryImage((String) item[2]);
					bean.setCategoryId((int) item[3]);
					getSubCategoryListByCategoryId.add(bean);
					
				}
				
			}
	
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSubCategoryListByCategoryId;
	}

	@Override
	public boolean deleteSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(subCategory);
			transaction.commit();
			session.close();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public SubCategory validateSubCategory(String subcatName) throws Exception {
		// TODO Auto-generated method stub
		SubCategory subCategory=new SubCategory();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(subCategory.getClass());
			criteria.add(Restrictions.eq("subCategoryName", subcatName));
			subCategory = (SubCategory) criteria.uniqueResult();
			return subCategory;
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
		return subCategory;
	}

	@Override
	public List<SubCategory> getSubCategoryById(int subCategoryId) throws Exception {
		// TODO Auto-generated method stub
		List<SubCategory> getSubCategory = new ArrayList<SubCategory>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM tbl_food_sub_category WHERE subCategoryId = "+subCategoryId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(SubCategory.class);
			getSubCategory = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSubCategory;
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(subCategory);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	

}
