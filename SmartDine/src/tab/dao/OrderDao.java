package tab.dao;

import java.util.List;

import tab.entity.Order;

public interface OrderDao {

	public boolean takeOrder(Order order)throws Exception;

	public List<Order> getOrderByTableName(String tableName)throws Exception;

}
