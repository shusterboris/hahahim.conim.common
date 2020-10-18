package entities;

public class Participant extends BasicEntity {
	private Long personId;
	private Float quantity;
	private boolean done = false;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Participant(Long personId, Float quantity, boolean done) {
		super();
		this.personId = personId;
		this.quantity = quantity;
		this.done = done;
	}

	public Participant(Long id, Long personId, Float quantity, boolean done) {
		super();
		this.personId = personId;
		this.quantity = quantity;
		this.done = done;
	}
}
