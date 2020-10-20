package entities;

import java.time.LocalDate;
import java.util.List;

import entities.enums.ProposalStatus;

/**
 * ���������� ����������� (����������� �� ���������� �������)
 * 
 * @author �������
 *
 */
public class Proposal extends BasicEntity {
	private String name;
	private List<CatItem> categories;
	private CatItem region;
	private Member initiator;
	private Float price;
	private Float lastPrice;
	private LocalDate dueDate;// ���� ��������� ������ ������
	private CatItem measure;
	private String status = ProposalStatus.INIT.getMessageKey(); // �� ������ TenderStatus
	private List<String> photos;
	private LocalDate publicationDate;
	private String winner;
	private Long winnerId;
	private Float total;
	private Integer countMembers;
	private LocalDate dateOfSailStarting;
	private LocalDate closeDate;
	private String description;

	public List<CatItem> getCategories() {
		return categories;
	}

	public void setCategories(List<CatItem> categories) {
		this.categories = categories;
	}

	public CatItem getRegions() {
		return region;
	}

	public void setRegions(CatItem regions) {
		this.region = regions;
	}

	public Person getAuthor() {
		return initiator;
	}

	public void setAuthor(Member author) {
		this.initiator = author;
	}

	public Float getMaxPrice() {
		return price;
	}

	public void setMaxPrice(Float maxPrice) {
		this.price = maxPrice;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public LocalDate getDateOfSailStarting() {
		return dateOfSailStarting;
	}

	public void setDateOfSailStarting(LocalDate dateOfSailStarting) {
		this.dateOfSailStarting = dateOfSailStarting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member getInitiator() {
		return initiator;
	}

	public void setInitiator(Member initiator) {
		this.initiator = initiator;
	}

	public Float getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Float lastPrice) {
		this.lastPrice = lastPrice;
	}

	public CatItem getMeasure() {
		return measure;
	}

	public void setMeasure(CatItem measure) {
		this.measure = measure;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getCountMembers() {
		return countMembers;
	}

	public void setCountMembers(Integer countMembers) {
		this.countMembers = countMembers;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ������������� ��� �������
	 * 
	 * @param id         - ���������� id ��� �������
	 * @param item       - �������� ������ �� ��������� �����
	 * @param categories - ��������� �� �����������
	 * @param region     - ������ �� �����������
	 * @param author     - ��������� �������, Person
	 * @param i          - ������������ ����, �� ������� �������� ���������� �����
	 * @param dueDate    - ���� ���������� �������
	 */
	public Proposal(Long id, String name, List<CatItem> categories, CatItem region, Member author, Float price,
			LocalDate dueDate) {
		super();
		this.name = name;
		this.categories = categories;
		this.region = region;
		this.initiator = author;
		this.price = price;
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return name.concat(", ").concat(region.getValue()).concat(", ").concat(initiator.toString());
	}

}
