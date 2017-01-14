package tab.service;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.TableDao;
import tab.entity.Tablee;

public class TableServiceImpl implements TableService {
	
	@Autowired
	TableDao tableDao;

	@Override
	public boolean addTable(Tablee table) throws Exception {
		// TODO Auto-generated method stub
		return tableDao.addTable(table);
	}
}
