package tab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.SubCategoryDao;
import tab.entity.SubCategory;
import tab.entity.SubCategoryBean;

public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	SubCategoryDao subCategoryDao;

	@Override
	public boolean addSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.addSubCategory(subCategory);
	}

	@Override
	public List<SubCategory> getSubCategoryList() throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.getSubCategoryList();
	}

	@Override
	public List<SubCategoryBean> getSubCategoryListById(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.getSubCategoryListByCategoryId(categoryId);
	}

	@Override
	public boolean deleteSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.deleteSubCategory(subCategory);
	}

	@Override
	public SubCategory validateSubCategory(String subcatName) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.validateSubCategory(subcatName);
	}

	@Override
	public List<SubCategory> getSubCategoryById(int subCategoryId) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.getSubCategoryById(subCategoryId);
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) throws Exception {
		// TODO Auto-generated method stub
		return subCategoryDao.updateSubCategory(subCategory);
	}
}
