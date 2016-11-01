package tab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_login")
public class User {
	@Id
	@GenericGenerator(name="tmo",strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="LoginId")
	private int loginId;
	@Column(name="UserName")
	private String userName;
	@Column(name="UserId")
	private String userId;
	@Column(name="Password")
	private String password;
	@Column(name="UserType")
	private String userType;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
