package proxies;

import java.io.Serializable;

// used only for BusinessPartner
public class Contact extends BasicEntity implements Serializable{
	private static final long serialVersionUID = 5998300011263073371L;
	private String firstName;
	private String lastName;
	private String phone;
  
  
public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String name) {
	this.lastName = name;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public Contact(String firstName, String name, String phone) {
	this.firstName = firstName;
	this.lastName = name;
	this.phone = phone;
}
}
