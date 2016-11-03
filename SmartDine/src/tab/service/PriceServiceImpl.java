package tab.service;

import org.springframework.beans.factory.annotation.Autowired;

import tab.dao.PriceDao;
import tab.entity.Price;

public class PriceServiceImpl implements PriceService {
	
	@Autowired
	PriceDao priceDao;
	
	@Override
	public boolean addPrice(Price price) throws Exception {
		// TODO Auto-generated method stub
		return priceDao.addPrice(price);
	}

}
