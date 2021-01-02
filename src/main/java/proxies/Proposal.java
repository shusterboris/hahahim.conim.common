package proxies;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import enums.ProposalStatus;

public class Proposal  implements Serializable{
	private static final long serialVersionUID = -8117381935020236594L;
	private long id;
	private String name;
	private List<CatItem> categories;//категория товара
	private CatItem region;
	private Member initiator;
	private float price = (float) 0.0; //розничная цена
	private float lastPrice = (float) 0.0; //достигнутая клубная цена
	private float nextPrice = (float) 0.0; //следующая клубная цена
	private LocalDate dueDate;
	private CatItem measure;
	private float threshold = (float) 0; //минимальная закупка
	private float thresholdmax = (float) 0;//верхний предел закупки
	private String status = ProposalStatus.INIT.getMessageKey(); // �� ������ TenderStatus
	private List<String> photos;
	private LocalDate publicationDate;
	private String supplier;
	private Long supplierId;
	private Float total = (float) 0.0;
	private Integer countMembers = 0;
	private LocalDate dateOfSailStarting;
	private LocalDate closeDate;
	private String description;
    private List<PriceProposal> priceProposals;
    private List<Address> stores;
    private List<CatItem> tags;//отметки
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Float getThresholdmax() {
		return thresholdmax;
	}

	public void setThresholdmax(Float thresholdmax) {
		this.thresholdmax = thresholdmax;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public List<Address> getStores() {
		return stores;
	}

	public void setStores(List<Address> stores) {
		this.stores = stores;
	}

	public List<CatItem> getCategories() {
		return categories;
	}

	public CatItem getRegion() {
		return region;
	}

	public void setRegion(CatItem region) {
		this.region = region;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<PriceProposal> getProposals() {
		return priceProposals;
	}

	public void setProposals(List<PriceProposal> proposals) {
		this.priceProposals = proposals;
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

	

	public Float getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Float lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Float getNextPrice() {
		return nextPrice;
	}

	public void setNextPrice(Float nextPrice) {
		this.nextPrice = nextPrice;
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

	public Person getInitiator() {
		return initiator;
	}

	public void setInitiator(Member author) {
		this.initiator = author;
	}

	public List<PriceProposal> getPriceProposals() {
		return priceProposals;
	}

	public void setPriceProposals(List<PriceProposal> priceProposals) {
		this.priceProposals = priceProposals;
	}


	public Float getThreshold() {
		return threshold;
	}

	public void setThreshold(Float threshold) {
		this.threshold = threshold;
	}

	@Override
	public String toString() {
		return name;
	}

}
