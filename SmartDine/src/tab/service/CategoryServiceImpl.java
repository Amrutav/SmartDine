package tab.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.CategoryDao;
import tab.entity.Category;

public class CategoryServiceImpl implements CategoryService {
	
		@Autowired
		private CategoryDao categoryDao;

		@Override
		public boolean addCategory(Category category) throws HibernateException {
			// TODO Auto-generated method stub
			return categoryDao.addCategory(category);
		}

		@Override
		public List<Category> getCategoryList() throws Exception {
			// TODO Auto-generated method stub
			return categoryDao.getCategoryList();
		}

		@Override
		public boolean deleteCategory(Category category) throws Exception {
			// TODO Auto-generated method stub
			return categoryDao.deleteCategory(category);
		}
	
		
	}

