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

		@Override
		public List<Category> getCategoryListById(int categoryId) throws Exception {
			// TODO Auto-generated method stub
			return categoryDao.categoryListById(categoryId);
		}

		@Override
		public boolean updateCategory(Category category) throws Exception {
			// TODO Auto-generated method stub
			return categoryDao.updateCategory(category);
		}

		@Override
		public Category validateCategory(String catName) throws Exception {
			// TODO Auto-generated method stub
			return categoryDao.validateCategory(catName);
		}
	
		
	}

