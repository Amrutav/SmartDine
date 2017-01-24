package tab.service;

import java.util.List;

import tab.entity.Order;

public interface OrderService {

	public boolean takeOrder(Order order)throws Exception;

	public List<Order> getOrderByTable(String tableName)throws Exception;



}
