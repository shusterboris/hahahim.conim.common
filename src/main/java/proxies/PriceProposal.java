package proxies;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import enums.PriceProposalType;

public class PriceProposal  implements Serializable{
	private static final long serialVersionUID = 7882895218501386694L;
	private long Id;
	private Long memberId;
	private Integer priceLevel;// 1, 2, 3
	private Long proposalId;
	private Float quantity;
	private Float price;
	private int proposalType = PriceProposalType.PARTNERS.ordinal();
	private String delivery;

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getProposalId() {
		return proposalId;
	}

	public void setProposalId(Long proposalId) {
		this.proposalId = proposalId;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getProposalType() {
		return proposalType;
	}

	public void setProposalType(int proposalType) {
		this.proposalType = proposalType;
	}

	
	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceProposal other = (PriceProposal) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (price == 0 || quantity == 0)
			return "";
		else
			return price.toString().concat(", кол-во: ").concat(quantity.toString());
	}
	
	public static void sort(List<PriceProposal> lst) {
		lst.sort(Collections.reverseOrder(
				(a, b) -> a.getPrice().compareTo(b.getPrice())
				));
		for(int i=0; i < lst.size(); i++)
			lst.get(i).setPriceLevel(i);
	}
}
