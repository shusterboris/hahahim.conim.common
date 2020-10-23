package proxies;

import java.util.ArrayList;

public class Member extends Person {
private Integer level; //member level
private ArrayList<String> regions;
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
