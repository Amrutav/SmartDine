package tab.service;

import tab.entity.Order;

public interface OrderService {

	public boolean takeOrder(Order order)throws Exception;

}
