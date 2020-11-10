package proxies;

import java.io.Serializable;

public class PriceProposal extends BasicEntity  implements Serializable{
	private static final long serialVersionUID = 7882895218501386694L;
	private Long memberId;
	private Long proposalId;
	private Float quantity;
	private Float price;
	private int proposalType;

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

	@Override
	public String toString() {
		return this.price.toString().concat(" for ").concat(this.quantity.toString());
	}
}
