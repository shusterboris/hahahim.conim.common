package proxies;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import enums.ProposalStatus;

public class Proposal  implements Serializable{
	private static final long serialVersionUID = -8117381935020236594L;
	private long id;
	private String name;
	private String category;//категория товара
	private String region;
	private Long initiator;
	private float price = (float) 0.0; //розничная цена
	private float lastPrice = (float) 0.0; //достигнутая клубная цена
	private float nextPrice = (float) 0.0; //следующая клубная цена
	private LocalDate dueDate; //дата окончания сбора заявок
	private String measure; //единица измерения
	private Float threshold; //минимальная закупка
	private Float thresholdmax;//верхний предел закупки
	private String status = ProposalStatus.INIT.getMessageKey(); 
	private List<String> photos; //имена файлов
	private LocalDate publicationDate;//дата публикации (утверждения модератором)
	private String supplier;
	private Long supplierId;
	private Float total = (float) 0.0;
	private Integer countMembers = 0;
	private LocalDate dateOfSailStarting; //дата начала продаж
	private LocalDate closeDate; //дата окончания акции
	@Column(length = 500)
	private String description;
    private List<PriceProposal> priceProposals;
    private List<Address> stores;
    private List<CatItem> tags;//отметки
	private Long bundle; // общая закупка purchase
	private Boolean intOnly;
    
	public Boolean getIntOnly() {
		return intOnly;
	}

	public void setIntOnly(Boolean intOnly) {
		this.intOnly = intOnly;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getNextPrice() {
		return nextPrice;
	}

	public void setNextPrice(float nextPrice) {
		this.nextPrice = nextPrice;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public List<CatItem> getTags() {
		return tags;
	}

	public void setTags(List<CatItem> tags) {
		this.tags = tags;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setLastPrice(float lastPrice) {
		this.lastPrice = lastPrice;
	}

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

	public Long getInitiator() {
		return initiator;
	}

	public void setInitiator(Long initiator) {
		this.initiator = initiator;
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

	public Long getBundle() {
		return bundle;
	}

	public void setBundle(Long bundle) {
		this.bundle = bundle;
	}

}
