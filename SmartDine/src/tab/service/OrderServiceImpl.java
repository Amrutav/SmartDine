package tab.service;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.OrderDao;
import tab.entity.Order;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public boolean takeOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.takeOrder(order);
	}
}
