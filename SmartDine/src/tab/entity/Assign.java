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
@Table(name="tbl_assign")
public class Assign {
	
	@Id
	@GenericGenerator(name="tmo", strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="AssignId")
	private int assignId;
	@ManyToOne
	@JoinColumn(name="WaiterId")
	private User user;
	@ManyToOne
	@JoinColumn(name="TableId")
	private Tablee table;
	public int getAssignId() {
		return assignId;
	}
	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tablee getTable() {
		return table;
	}
	public void setTable(Tablee table) {
		this.table = table;
	}
	
	
}
