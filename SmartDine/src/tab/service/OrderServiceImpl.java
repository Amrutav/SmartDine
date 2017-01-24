package tab.service;

import java.util.List;

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

	@Override
	public List<Order> getOrderByTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.getOrderByTableName(tableName);
	}

}
