package tab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_food_category")
public class Category {
	@Id
	@GenericGenerator(name="tmo", strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="CatagoryId")
	private int categoryId;
	@Column(name="CatagoryName")
	private String categoryName;
	@Column(name="CatagoryImage")
	private String CategoryImage;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return CategoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		CategoryImage = categoryImage;
	}
	

}
