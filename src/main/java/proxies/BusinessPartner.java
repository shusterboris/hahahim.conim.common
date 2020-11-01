package proxies;

import java.util.ArrayList;

public class BusinessPartner extends Store {
    private String name;
    private String fullName;
    private String phone;
    private ArrayList<Person> contacts;
    private ArrayList<Store> stores;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Person> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<Person> contacts) {
		this.contacts = contacts;
	}
	public ArrayList<Store> getStores() {
		return stores;
	}
	
	public void setStores(ArrayList<Store> stores) {
		this.stores = stores;
	}
	
	public BusinessPartner(String name, Address address, Long headQuatersId) {
		super(name, address, headQuatersId);
		this.headQuatersId = (long) 0;
	}

}
