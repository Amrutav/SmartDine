package tab.cont;

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
import org.springframework.web.bind.annotation.ResponseBody;

import tab.entity.Order;
import tab.entity.OrderJsonResonse;
import tab.entity.User;
import tab.entity.UserJsonResponse;
import tab.service.OrderService;

@Controller
@RequestMapping("/Order")
public class OrderCont {
	
	@Autowired
	OrderService orderService;
	
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
				/*int getId =  userServices.getMaxId();
				getId = getId+1;
				String prefix = "SD";
				String suffix = String.format("%04d", getId);*/   
				System.out.println(order.getItemId());
				order.getItemId();
				order.setDateTime(new Date());
				order.setPrice(80);
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
	
}
