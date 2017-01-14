package tab.entity;

import java.util.Map;

public class AssignJsonResponse {
	
	private String status;
	private Map<String, String> errorsMap;
	private Assign asign;
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
	public Assign getAsign() {
		return asign;
	}
	public void setAsign(Assign asign) {
		this.asign = asign;
	}
	
}
