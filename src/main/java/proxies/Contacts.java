package proxies;
// used only for BusinessPartner
public class Contacts {
  private String firstName;
  private String name;
  private String phone;
  
  
public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public Contacts(String firstName, String name, String phone) {
	this.firstName = firstName;
	this.name = name;
	this.phone = phone;
}
}
