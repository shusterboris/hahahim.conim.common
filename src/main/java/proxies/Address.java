package proxies;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = -6276857316780429416L;
	protected Long id;
	protected String region; // from catItem
	protected String settlement; // from catItem
	protected String streetAddress;
	protected Float latitude;
	protected Float altitude;
	protected Long parentId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		if (settlement != null && !settlement.isEmpty())
			if (b.length() > 0)
				b.append(", ").append(settlement);
			else
				b.append(settlement);
		if (streetAddress != null && !streetAddress.isEmpty())
			if (b.length() > 0)
				b.append(", ").append(streetAddress);
			else
				b.append(streetAddress);
		if (region != null && region.isEmpty())
			if (b.length() > 0)
				b.append(", (").append(region).append(")");
			else
				b.append(")").append(region).append(")");
		if (b.length() > 0)
			return b.toString();
		else
			return "";
	}

}
