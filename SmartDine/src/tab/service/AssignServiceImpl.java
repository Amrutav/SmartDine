package tab.service;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.AssignDao;
import tab.entity.Assign;

public class AssignServiceImpl implements AssignService {
	
	@Autowired
	AssignDao assignDao;

	@Override
	public boolean asignTable(Assign assign) throws Exception {
		// TODO Auto-generated method stub
		return assignDao.asignTable(assign);
	}
	
}
