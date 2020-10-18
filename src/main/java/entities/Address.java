package entities;

public class Address extends BasicEntity {
	// из справочника категория
	private String zipCode;
	private String region;
	private String settlment;
	private String streetAddress;
	private String appartments;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSettlment() {
		return settlment;
	}

	public void setSettlment(String settlment) {
		this.settlment = settlment;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getAppartments() {
		return appartments;
	}

	public void setAppartments(String appartments) {
		this.appartments = appartments;
	}

	public Address(String zipCode, String region, String settlment, String streetAddress, String appartments) {
		super();
		this.zipCode = zipCode;
		this.region = region;
		this.settlment = settlment;
		this.streetAddress = streetAddress;
		this.appartments = appartments;
	}

}
