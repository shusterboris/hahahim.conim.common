package entities;

import java.util.List;

import entities.enums.SuggestionType;

public class Suggestion extends BasicEntity {
	private int type = SuggestionType.TENDER.ordinal();
	private Float price = (float) 0.0;
	private List<Branch> branches;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Suggestion(int type, Float price, List<Branch> branches) {
		super();
		this.type = type;
		this.price = price;
		this.branches = branches;
	}

	public Suggestion(Long id, int type, Float price, List<Branch> branches) {
		this(type, price, branches);
		this.id = id;
	}

}
