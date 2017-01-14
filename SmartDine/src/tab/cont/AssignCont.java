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

import tab.entity.Assign;
import tab.entity.AssignJsonResponse;
import tab.service.AssignService;

@Controller
@RequestMapping("/Assign")
public class AssignCont {
	
	@Autowired
	AssignService assignService;
	
	private MessageSource messageSource;
	static final Logger logger = Logger.getLogger(UserCont.class);
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AssignJsonResponse addUser(@Valid @RequestBody Assign assign,BindingResult bindingResult){
		AssignJsonResponse assignJsonResponse = new AssignJsonResponse();
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
			assignJsonResponse.setErrorsMap(error);
			assignJsonResponse.setAsign(assign);
			assignJsonResponse.setStatus("ERROR");
			return assignJsonResponse;
		}else{
			try {
				boolean validUser = assignService.asignTable(assign);
				if(validUser){
					assignJsonResponse.setStatus("SUCCESS");
				}else{
					assignJsonResponse.setStatus("FAILED");
				}
				return assignJsonResponse;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return assignJsonResponse;
	}
}
