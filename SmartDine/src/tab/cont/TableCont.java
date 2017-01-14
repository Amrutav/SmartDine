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

import tab.entity.Tablee;
import tab.entity.TableJsonResponse;
import tab.service.TableService;

@Controller
@RequestMapping("/Table")
public class TableCont {
	
	@Autowired
	TableService tableService;
	
	private MessageSource messageSource;
	static final Logger logger = Logger.getLogger(TableCont.class);
	
	//Table Creation
	
		@RequestMapping(value="/addTable", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody TableJsonResponse addUser(@Valid @RequestBody Tablee table,BindingResult bindingResult){
			TableJsonResponse tableJsonResponse = new TableJsonResponse();
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
				tableJsonResponse.setErrorsMap(error);
				tableJsonResponse.setTable(table);
				tableJsonResponse.setStatus("ERROR");
				return tableJsonResponse;
			}else{
				try {
					
					boolean validUser = tableService.addTable(table);
					if(validUser){
						tableJsonResponse.setStatus("SUCCESS");
					}else{
						tableJsonResponse.setStatus("FAILED");
					}
					return tableJsonResponse;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return tableJsonResponse;
		}
}
