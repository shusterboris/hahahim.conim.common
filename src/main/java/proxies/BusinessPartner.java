package proxies;

import java.io.Serializable;
import java.util.List;

public class BusinessPartner implements Serializable {
	private static final long serialVersionUID = -7523924559237866260L;
	private long id;
	private String name;
	private String fullName;
	private String phone;
	private boolean supplier = false;
	private Double raiting; // оценка поставщика
	private String telegramId;
	private List<Contact> contacts;
	private List<Store> stores;

	public Double getRaiting() {
		return raiting;
	}

	public void setRaiting(Double raiting) {
		this.raiting = raiting;
	}

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

	public boolean isSupplier() {
		return supplier;
	}

	public void setSupplier(boolean supplier) {
		this.supplier = supplier;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getFullName());
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelegramId() {
		return telegramId;
	}

	public void setTelegramId(String telegramId) {
		this.telegramId = telegramId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
}
