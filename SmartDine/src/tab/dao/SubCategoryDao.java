package tab.dao;

import java.util.List;

import tab.entity.SubCategory;
import tab.entity.SubCategoryBean;

public interface SubCategoryDao {

	boolean addSubCategory(SubCategory subCategory)throws Exception;

	public List<SubCategory> getSubCategoryList()throws Exception;

	public List<SubCategoryBean> getSubCategoryListByCategoryId(int categoryId)throws Exception;

	boolean deleteSubCategory(SubCategory subCategory)throws Exception;

	public SubCategory validateSubCategory(String subcatName)throws Exception;

	public List<SubCategory> getSubCategoryById(int subCategoryId)throws Exception;

	public boolean updateSubCategory(SubCategory subCategory)throws Exception;

}
