package tab.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_table")
public class Tablee {
	
	@Id
	@GenericGenerator(name="tmo",strategy="increment")
	@GeneratedValue(generator="tmo")
	@Column(name="TableId")
	private int tableId;
	@Column(name="TableName")
	private String tableName;
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
