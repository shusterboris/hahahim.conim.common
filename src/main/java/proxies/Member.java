package proxies;

import java.io.Serializable;
import java.util.List;

public class Member extends Person implements Serializable {
	private static final long serialVersionUID = 627950708658994487L;
	private Integer level; // member level
	private List<String> regions;
	private Long partnerId;
	private String analytics;
	private String authorities;
	private String delivery1;
	private String delivery2;

	public String getDelivery1() {
		return delivery1;
	}

	public void setDelivery1(String delivery1) {
		this.delivery1 = delivery1;
	}

	public String getDelivery2() {
		return delivery2;
	}

	public void setDelivery2(String delivery2) {
		this.delivery2 = delivery2;
	}

	public String toString() {
		StringBuilder b;
		if (!(this.lastName == null || this.lastName.isEmpty())) {
			b = new StringBuilder(this.lastName).append(" ").append(this.firstName);
		} else
			b = new StringBuilder(this.firstName);
		return b.toString();
	}

	public String getLocation() {
		if (regions == null)
			return "";
		if (regions.size() > 0)
			return String.join(", ", regions);
		return "";
	}

	public String getAnalytics() {
		return analytics;
	}

	public void setAnalytics(String analytics) {
		this.analytics = analytics;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

}
