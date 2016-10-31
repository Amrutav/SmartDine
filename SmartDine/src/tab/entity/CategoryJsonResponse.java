package tab.entity;

import java.util.Map;

public class CategoryJsonResponse {
	
	private String status;
	private Map<String, String> errorsMap;
	private Category category;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getErrorsMap() {
		return errorsMap;
	}
	public void setErrorsMap(Map<String, String> errorsMap) {
		this.errorsMap = errorsMap;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
