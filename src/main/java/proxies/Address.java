package proxies;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = -6276857316780429416L;
	protected String region; // from catItem
	protected String settlement; // from catItem
	protected String streetAddress;
	protected Float latitude;
	protected Float altitude;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlment) {
		this.settlement = settlment;
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

	@Override
	public String toString() {
		return region + ", " + settlement + ", " + streetAddress;
	}

}
