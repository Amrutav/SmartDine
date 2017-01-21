package tab.dao;

import tab.entity.Order;

public interface OrderDao {

	public boolean takeOrder(Order order)throws Exception;

}
