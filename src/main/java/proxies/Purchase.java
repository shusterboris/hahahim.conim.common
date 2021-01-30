package proxies;

import java.io.Serializable;
import java.time.LocalDate;

import enums.ProposalStatus;

public class Purchase implements Serializable {

	private static final long serialVersionUID = 683915625637469600L;
	private String name;
	private ProposalStatus state;
	private Long initiator;
	private Float sumOrders;
	private LocalDate currDate; // дата инициации либо дата выкупа в зависимости от состояния
	public String getName() {
		return name;
	}

	public Float getSumOrders() {
		return sumOrders;
	}

	public void setSumOrders(Float sumOrders) {
		this.sumOrders = sumOrders;
	}

	public LocalDate getCurrDate() {
		return currDate;
	}

	public void setCurrDate(LocalDate currDate) {
		this.currDate = currDate;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Long getInitiator() {
		return initiator;
	}

	public void setInitiator(Long initiator) {
		this.initiator = initiator;
	}
}
