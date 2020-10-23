package proxies;

public class Store extends BasicEntity {
	private String name;
	private Address address;
	protected Long headQuatersId = (long) 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getHeadQuatersId() {
		return headQuatersId;
	}

	public void setHeadQuatersId(Long headQuatersId) {
		this.headQuatersId = headQuatersId;
	}

	public Store(String name, Address address, Long headQuatersId) {
		super();
		this.name = name;
		this.address = address;
		this.headQuatersId = headQuatersId;
	}

	public Store(Long id, String name, Address address, Long headQuatersId) {
		this(name, address, headQuatersId);
		this.id = id;
	}

}
