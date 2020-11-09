package entities;

/**
 * 
 * @author ������� ������������� ����������: ��������� �������, �������, ������
 *         � �.�. ����� ���� ��������������, ����� parentId �������� id
 *         ������������� ������ ����� ������������� �� �������� ���� � �������,
 *         �������� � sortOrder
 */
public class CatItem extends BasicEntity {
	private String key;
	private String language;
	private Long parentId = (long) 0;
	private String value;
	private Integer sortOrder = 1000;
	private String addValue;  //file name with image

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public CatItem(String key, String language, Long parentId, String value, Integer sortOrder) {
		super();
		this.key = key;
		this.language = language;
		this.parentId = parentId;
		this.value = value;
		this.sortOrder = sortOrder;
	}

	public CatItem(Long id, String key, String language, Long parentId, String value, Integer sortOrder) {
		this(key, language, parentId, value, sortOrder);
		this.id = id;
		this.parentId = parentId;
	}

	public CatItem(Long id, String key, String value, String language) {
		this(key, language, (long) 0, value, 1000);
		this.id = id;
	}

	@Override
	public String toString() {
		return value.concat(" ,id:").concat(String.valueOf(id)).concat(", key:").concat(key).concat("_")
				.concat(language).concat(", parent:".concat(String.valueOf(parentId)));
	}

}
