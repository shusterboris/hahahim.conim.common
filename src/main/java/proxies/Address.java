package proxies;

public class Address extends BasicEntity {

	private String region;  //from catItem
	private String settlment;  //from catItem
	private String streetAddress;
	private Float latitude;
	private Float altitude;
	
	

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

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
	}

	

}
