package tab.cont;

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

import tab.entity.Category;
import tab.entity.Item;
import tab.entity.ItemJsonResponse;
import tab.entity.Price;
import tab.entity.PriceJsonResponse;
import tab.service.PriceService;

@Controller
@RequestMapping("/price")
public class PriceCont {
	
	@Autowired
	PriceService priceServices;
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(Category.class);
	
	@RequestMapping(value = "/addPrice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PriceJsonResponse addPrice(@Valid @RequestBody Price price, BindingResult bindingResult ){
		PriceJsonResponse priceJsonResponse = new PriceJsonResponse();
		if(bindingResult.hasErrors()){
			Map<String, String> errors = new HashMap<String, String>();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for(FieldError fieldError : fieldErrors){
				String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldError.getCode());
				String string = resolveMessageCodes[0];
				logger.debug("resolveMessageCodes: "+string);
				String message = messages.getMessage(string+"."+fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
				logger.debug("Message"+message);
				errors.put(fieldError.getField(), message);
			}
			priceJsonResponse.setErrorsMap(errors);
			priceJsonResponse.setPrice(price);
			priceJsonResponse.setStatus("ERROR");
			return priceJsonResponse;
		}else{
			try{
				boolean flag = priceServices.addPrice(price);
				if(flag) priceJsonResponse.setStatus("SUCCESS");
				else priceJsonResponse.setStatus("FAILED");
				return priceJsonResponse;
			}catch (Exception e) {
				priceJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return priceJsonResponse;
	}
	
}
