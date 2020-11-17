package proxies;

import java.util.ArrayList;

public class Member extends Person {
	private static final long serialVersionUID = 627950708658994487L;
	private Integer level; //member level
	private ArrayList<String> regions;
	private Long partnerId;

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
	
	public ArrayList<String> getRegions() {
		return regions;
	}
	
	public void setRegions(ArrayList<String> regions) {
		this.regions = regions;
	}

}
