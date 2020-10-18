package entities;

public class BusinessPartner extends Branch {

	public BusinessPartner(String name, Address address, Long headQuatersId) {
		super(name, address, headQuatersId);
		this.headQuatersId = (long) 0;
	}

}
