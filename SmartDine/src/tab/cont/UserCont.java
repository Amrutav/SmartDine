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
import tab.entity.User;
import tab.entity.UserJsonResponse;
import tab.service.UserService;

@Controller
@RequestMapping("/User")
public class UserCont {
	
	@Autowired
	UserService userServices;
	
	private MessageSource messageSource;
	static final Logger logger = Logger.getLogger(UserCont.class);
	
	//User Login
	
	@RequestMapping(value="/login", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse login(@Valid @RequestBody User user,BindingResult bindingResult){
		UserJsonResponse userJsonResponse = new UserJsonResponse();
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
			userJsonResponse.setErrorsMap(error);
			userJsonResponse.setUser(user);
			userJsonResponse.setStatus("ERROR");
			return userJsonResponse;
		}else{
			try {
				System.out.println(user.getUserName());
				System.out.println(user.getPassword());
				System.out.println(user.getUserType());
				User validUser = userServices.getAuthenticateUser(user);
				if(validUser.getLoginId() > 0){
					userJsonResponse.setStatus("SUCCESS");
					userJsonResponse.setUser(validUser);
				}else{
					userJsonResponse.setStatus("FAILED");
				}
				return userJsonResponse;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userJsonResponse;
	}
	
	
	//User Creation
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserJsonResponse addUser(@Valid @RequestBody User user,BindingResult bindingResult){
		UserJsonResponse userJsonResponse = new UserJsonResponse();
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
			userJsonResponse.setErrorsMap(error);
			userJsonResponse.setUser(user);
			userJsonResponse.setStatus("ERROR");
			return userJsonResponse;
		}else{
			try {
				int getId =  userServices.getMaxId();
				getId = getId+1;
				String prefix = "SD";
				String suffix = String.format("%04d", getId);               
				user.setUserId(prefix.concat(suffix));
				System.out.println(prefix.concat(suffix));
				boolean validUser = userServices.addUser(user);
				if(validUser){
					userJsonResponse.setStatus("SUCCESS");
				}else{
					userJsonResponse.setStatus("FAILED");
				}
				return userJsonResponse;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userJsonResponse;
	}
}
