package tab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_food_sub_category")
public class SubCategory {
	
	@Id
	@GenericGenerator(name="tmo", strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="SubCategoryId")
	private int subCategoryId;
	@Column(name="SubCategoryName")
	private String subCategoryName;
	@Column(name="SubCategoryImage")
	private String subCategoryImage;
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getSubCategoryImage() {
		return subCategoryImage;
	}
	public void setSubCategoryImage(String subCategoryImage) {
		this.subCategoryImage = subCategoryImage;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
