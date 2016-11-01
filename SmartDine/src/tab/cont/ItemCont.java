package tab.cont;

import java.util.ArrayList;

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

import tab.entity.Category;
import tab.entity.Item;
import tab.entity.ItemJsonResponse;
import tab.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemCont {
	@Autowired
	ItemService itemServices;
	private MessageSource messages;
	private boolean flag=false;
	static final Logger logger = Logger.getLogger(Category.class);
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ItemJsonResponse addNewSubject(@Valid @RequestBody Item item, BindingResult bindingResult ){
		ItemJsonResponse itemJsonResponse = new ItemJsonResponse();
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
			itemJsonResponse.setErrorsMap(errors);
			itemJsonResponse.setItem(item);
			itemJsonResponse.setStatus("ERROR");
			return itemJsonResponse;
		}else{
			try{
				boolean flag = itemServices.addItem(item);
				if(flag) itemJsonResponse.setStatus("SUCCESS");
				else itemJsonResponse.setStatus("FAILED");
				return itemJsonResponse;
			}catch (Exception e) {
				itemJsonResponse.setStatus(e.toString());
				logger.error("Exception Occurs in : ", e);
			}
		}
		return itemJsonResponse;
	}
	
	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemList(){
		List<Item> itemList = new ArrayList<Item>();
		try {
			System.out.println("HELLO");
			itemList = itemServices.getItemList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemList;
	}
	
	@RequestMapping(value = "/itemListByCategoryId", method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemListByCategoryId(@RequestParam(value = "categoryId") int categoryId){
		List<Item> itemListByCategoryId = new ArrayList<Item>();
		try {
			System.out.println("HELLO");
			itemListByCategoryId = itemServices.getItemListByCategoryId(categoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemListByCategoryId;
	}
	
	@RequestMapping(value="/deleteItem", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ItemJsonResponse deleteItem(@Valid @RequestBody Item item){
		ItemJsonResponse itemJsonResponse = new ItemJsonResponse();
		System.out.println(item.getItemId());
		try{
			flag = itemServices.deleteItem(item);
			if(flag){
				itemJsonResponse.setStatus("SUCCSS");
			}else {
				itemJsonResponse.setStatus("FAILED");
			}
		}catch (Exception e){
			itemJsonResponse.setStatus(e.toString());
			logger.error(e);
			System.out.println(e);
		}
		return itemJsonResponse;
		
	}

}
