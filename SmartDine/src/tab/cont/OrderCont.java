package tab.cont;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tab.entity.Item;
import tab.entity.Order;
import tab.entity.OrderJsonResonse;
import tab.service.ItemService;
import tab.service.OrderService;

@Controller
@RequestMapping("/Order")
public class OrderCont {
	
	@Autowired
	OrderService orderService;
	@Autowired
	ItemService itemServices;
	
	private MessageSource messageSource;
	static final Logger logger = Logger.getLogger(OrderCont.class);
	
	//Take Order
	@RequestMapping(value="/takeOrder", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OrderJsonResonse takeOrder(@Valid @RequestBody Order order,BindingResult bindingResult){
		OrderJsonResonse orderJsonResponse = new OrderJsonResonse();
		if(bindingResult.hasErrors()){
			Map<String, String> error = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("ResolveMessageCodes : "+string);
				String messages = messageSource.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Messages : "+messages);
				error.put(fieldError.getField(), messages);
			}
			orderJsonResponse.setErrorsMap(error);
			orderJsonResponse.setOrder(order);
			orderJsonResponse.setStatus("ERROR");
			return orderJsonResponse;
		}else{
			try {
				List<Item> itemById = new ArrayList<Item>();
				double priceFull=0;
			    double priceHalf=0;
			    String serving = null;
			    int quantity=0;
			    double price=0;
				int itemId=order.getItemId();
				System.out.println(itemId);
			    itemById = itemServices.getItemById(itemId);
			    for(int i = 0; i<itemById.size();i++){
			    	priceFull=itemById.get(i).getPriceFull();
			    	System.out.println(priceFull);
			    	priceHalf=itemById.get(i).getPriceHalf();
			    	System.out.println(priceHalf);
			    }			    
			    serving = order.getServing();
			    quantity = order.getQuantity();
			    String servF="full";
			    String servH="half";
			    if(serving.equalsIgnoreCase(servF)){
			    	price=priceFull*quantity;
			    }else if(serving.equalsIgnoreCase(servH)){
			    	price=priceHalf*quantity;
			    }
			    
				order.setDateTime(new Date());
				order.setPrice(price);
				boolean validUser = orderService.takeOrder(order);
				if(validUser){
					orderJsonResponse.setStatus("SUCCESS");
				}else{
					orderJsonResponse.setStatus("FAILED");
				}
				return orderJsonResponse;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderJsonResponse;
	}
	
	
	//View Order By table name
	
	@RequestMapping(value = "/orderByTableName", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Order> orderByTableName( @RequestParam(value = "tableName") String tableName) {
		List<Order> orderByTable = new ArrayList<Order>();
	    try {
	    	orderByTable = orderService.getOrderByTable(tableName);	        
	    	return orderByTable;
	       } catch (Exception e) {
	    	logger.error("Exception occurs in", e);
	    }
	   	return orderByTable;
	}
	
}
