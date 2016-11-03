package tab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import tab.entity.Price;

public class PriceDaoImpl implements PriceDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction = null;
	Session session = null;
	
	@Override
	public boolean addPrice(Price price) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(price);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
