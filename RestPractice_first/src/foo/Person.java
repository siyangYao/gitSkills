package foo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Component
public class Person {
	
	String userName;
	
	String Id;
	
	String adress;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	
}
