package foo.validate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foo.dao.UserDAO;

@Component("Validation")
public class Validation {
	
	@Autowired
	private UserDAO userDAO;
	
	private String USERNAME_PATTERN="^[a-zA-Z0-9_-]{3,15}$";
	
	private Pattern pattern;
	private Matcher matcher;
	
	//validate password
	public boolean validatePasswordMatch(String password, String username) throws SQLException{
		ResultSet rs = userDAO.selectByUserName(username);
		rs.next();
		if(rs.getString("password").equals(password))
			return true;
		return false;
	}
	
	public boolean validateRegisterPassword(String password){
		if(!validateLength(password)) return false;
		if(!validateCapitalLetterAndSpace(password)) return false;
		return true;
	}
	
	public boolean validateLength(String password){
		if(password.length()>=8 && password.length()<=12) 
			return true;
		return false;
	}
	
	public boolean validateCapitalLetterAndSpace(String password){
		boolean resultCapital=false;
		
		for(int i=0;i<password.length();i++){
			if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
				resultCapital = true;
			if(password.charAt(i)==' ')
				return false;
		}
		return resultCapital;
	}
	
	//validate username
	public boolean validateUsername(String username){
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(username);
		return matcher.matches();
	}
}
