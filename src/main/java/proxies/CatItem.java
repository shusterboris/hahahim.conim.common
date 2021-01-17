package proxies;

import java.io.Serializable;


public class CatItem extends BasicEntity implements Serializable{
	private static final long serialVersionUID = -9215990634396625375L;
	private String key;
	private String language;
	private String parentKey ;
	private String value;
	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}


	/**
	 * if I need special sort order, not by alphabet
	 */
	private Integer sortOrder = 1000;
	/**
	 * additional info, particularly name of image file
	 */
	private String addValue;  

	public String getAddValue() {
		return addValue;
	}

	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public CatItem(Long id, String key, String language, String value) {
		this.id = id;
		this.key = key;
		this.language = language;
		this.value = value;
		this.sortOrder = 1000;
	}

	public CatItem(Long id, String key, String language, String value, Integer sortOrder, String parentKey) {
		this(id, key, language, value);
		this.parentKey = parentKey;
		this.sortOrder = sortOrder;
	}


	@Override
	public String toString() {
		return this.value;
	}

}
