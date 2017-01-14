package tab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.Tablee;

public class TableDaoImpl implements TableDao {
	
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	@Override
	public boolean addTable(Tablee table) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(table);
			transaction.commit();
			boo = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return boo;
	}

}
