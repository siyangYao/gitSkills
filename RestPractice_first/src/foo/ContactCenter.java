package foo;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import foo.dao.UserDAO;
import foo.validate.PasswordEncryAndDecry;
import foo.validate.Validation;


@Controller
public class ContactCenter {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncryAndDecry ped;
	
	@Autowired
	private Validation validation;
	
	private String errorCode;
	
	@RequestMapping(method=RequestMethod.GET, value="/form")
	public ModelAndView getForm(){
		return new ModelAndView("form","command",new Person());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/register")
	public ModelAndView getRegisterForm(){
		return new ModelAndView("register","command",new Person());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String getUserInfo(@ModelAttribute("person")Person person, ModelMap model) throws SQLException{
		String userName = person.getUserName();
		String password = person.getId();
		
		if(userDAO.isExist(userName)) {
			if(validation.validatePasswordMatch(ped.encrypt(password), userName)) {
				model.addAttribute("username", userName);
				return "resultLogin";
			}
			errorCode = Constants.ERROR_PASSWORD_LOGIN;
		} else {
			errorCode = Constants.ERROR_USERNAME_LOGIN;
		}
		
		model.addAttribute("errorCode", errorCode);
		return "errorLogin";	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String setUserInfo(@ModelAttribute("person")Person person, ModelMap model){
		String userName = person.getUserName();
		String password = person.getId();
		
		if(!validation.validateUsername(userName)) {
			errorCode = Constants.INVALID_USERNAME_FORMAT;
			model.addAttribute("errorCode", errorCode);
			return "errorRegister";
		}
			
		if(userDAO.isExist(userName)) {
			errorCode = Constants.USERNAME_EXITS;
			model.addAttribute("errorCode", errorCode);
			return "errorRegister";
		}
			
		if(validation.validateRegisterPassword(password))
			userDAO.insert(userName, ped.encrypt(password));
		else {
			errorCode = Constants.INVALID_PASSWORD_FORMAT;
			model.addAttribute("errorCode", errorCode);
			return "errorRegister";
		}
		
		return "resultRegister";
	}
}
