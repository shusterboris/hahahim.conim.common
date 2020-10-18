package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.TenderStatus;

public class Tender extends BasicEntity {
	private List<Item> items;
	private List<CatItem> categories;
	private List<CatItem> regions;
	private Person author;
	private Integer maxPrice;
	private LocalDate dueDate;
	private String status = TenderStatus.INIT.getMessageKey(); // Из набора TenderStatus
	private LocalDate dateOfPublication;
	private String winner;
	private Long winRecId;
	private LocalDate dateOfSailStarting;
	private LocalDate dateOfArchiving;
	private List<Participant> participants;
	private List<Suggestion> suggestions;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<CatItem> getCategories() {
		return categories;
	}

	public void setCategories(List<CatItem> categories) {
		this.categories = categories;
	}

	public List<CatItem> getRegions() {
		return regions;
	}

	public void setRegions(List<CatItem> regions) {
		this.regions = regions;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
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

	public LocalDate getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(LocalDate dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Long getWinRecId() {
		return winRecId;
	}

	public void setWinRecId(Long winRecId) {
		this.winRecId = winRecId;
	}

	public LocalDate getDateOfSailStarting() {
		return dateOfSailStarting;
	}

	public void setDateOfSailStarting(LocalDate dateOfSailStarting) {
		this.dateOfSailStarting = dateOfSailStarting;
	}

	public LocalDate getDateOfArchiving() {
		return dateOfArchiving;
	}

	public void setDateOfArchiving(LocalDate dateOfArchiving) {
		this.dateOfArchiving = dateOfArchiving;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	/**
	 * Исключительно для отладки
	 * 
	 * @param id         - уникальный id для таблицы
	 * @param item       - название товара на избранном языке
	 * @param Language   - язык для названия, 2 буквы в соответствии с ISO (EN,RU)
	 * @param categories - категория из справочника
	 * @param regions    - регион из справочника
	 * @param author     - инициатор тендера, Person
	 * @param maxPrice   - максимальная цена, по которой участник приобретет товар
	 * @param dueDate    - дата завершения тендера
	 */
	public Tender(Long id, String item, String Language, List<CatItem> categories, List<CatItem> regions, Person author,
			Integer maxPrice, LocalDate dueDate) {
		super();
		if (Language == null)
			Language = "RU";
		Item newItem = new Item(item, Language.toUpperCase());
		this.items = new ArrayList<Item>();
		this.items.add(newItem);
		this.categories = categories;
		this.regions = regions;
		this.author = author;
		this.maxPrice = maxPrice;
		this.dueDate = dueDate;
	}

}
