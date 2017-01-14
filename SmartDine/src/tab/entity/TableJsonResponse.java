package tab.entity;

import java.util.Map;

public class TableJsonResponse {
	
	private String status;
	private Map<String, String> errorsMap;
	private Tablee table;
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
	public Tablee getTable() {
		return table;
	}
	public void setTable(Tablee table) {
		this.table = table;
	}
	
}
