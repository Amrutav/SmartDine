package tab.dao;

import java.util.List;

import org.hibernate.HibernateException;

import tab.entity.Category;

public interface CategoryDao {
	public boolean addCategory(Category category)throws HibernateException;

	public List<Category> getCategoryList()throws Exception;

	public boolean deleteCategory(Category category)throws Exception;

}
