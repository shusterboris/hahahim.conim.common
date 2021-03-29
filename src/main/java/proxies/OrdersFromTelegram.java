package proxies;

import java.io.Serializable;
import java.util.Set;

public class OrdersFromTelegram implements Serializable{

	public class MemberT {
		private Set<String> delivery;

		public Set<String> getDelivery() {
			return delivery;
		}

		public void setDelivery(Set<String> delivery) {
			this.delivery = delivery;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelegram() {
			return telegram;
		}

		public void setTelegram(String telegram) {
			this.telegram = telegram;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPreferableAddress() {
			return preferableAddress;
		}

		public void setPreferableAddress(String preferableAddress) {
			this.preferableAddress = preferableAddress;
		}

		private long id;
		private String firstName;
		private String lastName;
		private String phoneNumber;
		private String email;
		private String telegram;
		private String address;
		private String preferableAddress;

	}
	private static final long serialVersionUID = 5543794728421273537L;
	private Set<OrderFromTelegram> items;

	public Set<OrderFromTelegram> getItems() {
		return items;
	}

	public void setItems(Set<OrderFromTelegram> items) {
		this.items = items;
	}

	public MemberT getMember() {
		return member;
	}

	public void setMember(MemberT member) {
		this.member = member;
	}
	private MemberT member;
}
