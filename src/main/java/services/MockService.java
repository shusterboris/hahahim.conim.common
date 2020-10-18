package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.UserSettings;
import entities.CatItem;

public class MockService {
	private Long id = (long) 10000;
	private List<CatItem> categories = new ArrayList<CatItem>();
	private Map<String, CatItem> catByName = new HashMap<String, CatItem>();
	private Map<Long, CatItem> catById = new HashMap<Long, CatItem>();

	public List<CatItem> getCatsByCategory(String key, String language) {
		if (language == null)
			language = UserSettings.getChoosenLanguage();
		final String lang = language;
		List<CatItem> items = new ArrayList<CatItem>();
		catByName.forEach((k, value) -> {
			if (k.startsWith(key) && lang.equalsIgnoreCase(value.getLanguage()))
				items.add(value);
		});
		return items;
	}

	public List<CatItem> getRegionsList(String language) {
		return getCatsByCategory("Country.Regions", language);
	}

	public List<String> getRegionsString(String language) {
		List<CatItem> items = getCatsByCategory("Country.Regions", language);
		List<String> result = new ArrayList<String>();
		for (CatItem item : items)
			result.add(item.getValue());
		return result;
	}

	public List<CatItem> getSettlmentsList(Object parentObj, String language) {
		List<CatItem> result = new ArrayList<CatItem>();
		CatItem region = null;
		if (parentObj instanceof Long) {
			Long id = (Long) parentObj;
			region = getCatById(id);
		} else if (parentObj instanceof String) {
			String key = (String) parentObj;
			region = getCatByName("Country.Regions" + "-" + key);
		} else if (parentObj instanceof String) {
			region = (CatItem) parentObj;
		}
		List<CatItem> settlments = getCatsByCategory("Regions.Settlments", language);
		Long parentId = region.getId();
		for (CatItem item : settlments)
			if (item.getParentId() == parentId)
				result.add(item);
		return result;
	}

	public List<String> getSettlmentsStrings(Object parentObj, String language) {
		List<CatItem> items = getSettlmentsList(parentObj, language);
		List<String> result = new ArrayList<String>();
		for (CatItem item : items)
			result.add(item.getValue());
		return result;
	}

	public CatItem getCatByName(String name) {
		return catByName.get(name);
	}

	public CatItem getCatById(Long id) {
		return catById.get(id);
	}

	private CatItem addToParent(CatItem parent, String itemKey, String itemValue, String itemLanguage) {
		CatItem item = new CatItem(id++, itemKey, itemLanguage, parent.getId(), itemValue, 0);
		catByName.put(item.getKey() + "-" + item.getValue(), item);
		catById.put(item.getId(), item);
		return item;
	}

	public void createRegions() {
		List<CatItem> result = new ArrayList<CatItem>();
		result.add(new CatItem(id++, "Country.Regions", "��������", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "�����", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "�����", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "�����������", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "����� � �������", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "����-����", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "���������", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "North", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "South", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "Haifa", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "Center", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "Judea and Samaria", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "Tel-Aviv", "EN"));
		result.add(new CatItem(id++, "Country.Regions", "Jerusalem", "EN"));
		for (CatItem item : result) {
			catByName.put("Country.Regions" + "-" + item.getValue(), item);
			catById.put(item.getId(), item);
		}
	}

	public void createSettlments() {
		addToParent(getCatByName("Country.Regions-��������"), "Regions.Settlments", "��������", "RU");
		addToParent(getCatByName("Country.Regions-��������"), "Regions.Settlments", "���� �����", "RU");
		addToParent(getCatByName("Country.Regions-��������"), "Regions.Settlments", "������ ����", "RU");
		addToParent(getCatByName("Country.Regions-�����"), "Regions.Settlments", "�����", "RU");
		addToParent(getCatByName("Country.Regions-�����"), "Regions.Settlments", "�����", "RU");
		addToParent(getCatByName("Country.Regions-�����"), "Regions.Settlments", "������", "RU");
		addToParent(getCatByName("Country.Regions-�����"), "Regions.Settlments", "����-����", "RU");
		addToParent(getCatByName("Country.Regions-�����"), "Regions.Settlments", "�����-��-����", "RU");
		addToParent(getCatByName("Country.Regions-�����������"), "Regions.Settlments", "��� ��", "RU");
		addToParent(getCatByName("Country.Regions-�����������"), "Regions.Settlments", "�������", "RU");
		addToParent(getCatByName("Country.Regions-�����������"), "Regions.Settlments", "���� ����", "RU");
		addToParent(getCatByName("Country.Regions-�����������"), "Regions.Settlments", "�����", "RU");
		addToParent(getCatByName("Country.Regions-����� � �������"), "Regions.Settlments", "������", "RU");
		addToParent(getCatByName("Country.Regions-���������"), "Regions.Settlments", "���������", "RU");
		addToParent(getCatByName("Country.Regions-���������"), "Regions.Settlments", "���� �����", "RU");
		addToParent(getCatByName("Country.Regions-����-����"), "Regions.Settlments", "����-���� �������", "RU");
		addToParent(getCatByName("Country.Regions-����-����"), "Regions.Settlments", "����� �����", "RU");
		addToParent(getCatByName("Country.Regions-����-����"), "Regions.Settlments", "����", "RU");

		addToParent(getCatByName("Country.Regions-North"), "Regions.Settlments", "Karmiel", "EN");
		addToParent(getCatByName("Country.Regions-North"), "Regions.Settlments", "Kfar Manda", "EN");
		addToParent(getCatByName("Country.Regions-North"), "Regions.Settlments", "Natsrat Elit", "EN");
		addToParent(getCatByName("Country.Regions-Haifa"), "Regions.Settlments", "Haifa", "EN");
		addToParent(getCatByName("Country.Regions-Haifa"), "Regions.Settlments", "Nesher", "EN");
		addToParent(getCatByName("Country.Regions-Haifa"), "Regions.Settlments", "Krayot", "EN");
		addToParent(getCatByName("Country.Regions-South"), "Regions.Settlments", "Beer Sheva", "EN");
		addToParent(getCatByName("Country.Regions-South"), "Regions.Settlments", "Rishon-le-Zion", "EN");
		addToParent(getCatByName("Country.Regions-Center"), "Regions.Settlments", "Bat yam", "EN");
		addToParent(getCatByName("Country.Regions-Center"), "Regions.Settlments", "Gertslia", "EN");
		addToParent(getCatByName("Country.Regions-Center"), "Regions.Settlments", "Kfar saba", "EN");
		addToParent(getCatByName("Country.Regions-Center"), "Regions.Settlments", "Ramla", "EN");
		addToParent(getCatByName("Country.Regions-Judea and Samaria"), "Regions.Settlments", "Ariel", "EN");
		addToParent(getCatByName("Country.Regions-Jerusalem"), "Regions.Settlments", "Jerusalem", "EN");
		addToParent(getCatByName("Country.Regions-Jerusalem"), "Regions.Settlments", "Beit shemesh", "EN");
		addToParent(getCatByName("Country.Regions-Tel-Aviv"), "Regions.Settlments", "Tel-Aviv savidor", "EN");
		addToParent(getCatByName("Country.Regions-Tel-Aviv"), "Regions.Settlments", "Petah tikva", "EN");
		addToParent(getCatByName("Country.Regions-Tel-Aviv"), "Regions.Settlments", "Jaffo", "EN");
	}

	private void createGoodsCategory() {
		CatItem item = new CatItem(id++, "Goods.Category", "�������� �������", "RU");
		addToParent(item, "Goods.Category", "������ ��������", "RU");
		addToParent(item, "Goods.Category", "�������� ��������", "RU");
		addToParent(item, "Goods.Category", "����������", "RU");
		addToParent(item, "Goods.Category", "��������", "RU");

		item = new CatItem(id++, "Goods.Category", "������", "RU");
		addToParent(item, "Goods.Category", "�������� ������", "RU");
		addToParent(item, "Goods.Category", "������ ������� �������", "RU");
		addToParent(item, "Goods.Category", "�������", "RU");

		item = new CatItem(id++, "Goods.Category", "�����������", "RU");
		addToParent(item, "Goods.Category", "������ � ����", "RU");
		addToParent(item, "Goods.Category", "����������� � ����������", "RU");
		addToParent(item, "Goods.Category", "��������� ����������", "RU");

		item = new CatItem(id++, "Goods.Category", "������ ��� ����", "RU");
		addToParent(item, "Goods.Category", "�����", "RU");
		addToParent(item, "Goods.Category", "�������", "RU");
		addToParent(item, "Goods.Category", "������", "RU");
		// ********************************************************
		item = new CatItem(id++, "Goods.Category", "Food", "EN");
		addToParent(item, "Goods.Category", "Meat", "EN");
		addToParent(item, "Goods.Category", "Milk", "EN");
		addToParent(item, "Goods.Category", "Delicacies", "EN");
		addToParent(item, "Goods.Category", "Drinks", "EN");

		item = new CatItem(id++, "Goods.Category", "Services", "EN");
		addToParent(item, "Goods.Category", "Learning of languages", "EN");
		addToParent(item, "Goods.Category", "Household appliances repair", "EN");
		addToParent(item, "Goods.Category", "Styling", "EN");

		item = new CatItem(id++, "Goods.Category", "Electronic devices", "EN");
		addToParent(item, "Goods.Category", "Music and audio", "EN");
		addToParent(item, "Goods.Category", "TV and computers", "EN");
		addToParent(item, "Goods.Category", "Mobile devices", "EN");

		item = new CatItem(id++, "Goods.Category", "Goods for home", "EN");
		addToParent(item, "Goods.Category", "Kitchens", "EN");
		addToParent(item, "Goods.Category", "Bedrooms", "EN");
		addToParent(item, "Goods.Category", "Toilets and Baths", "EN");

	}

	public List<CatItem> getCategories() {
		return categories;
	}

	public void setCategories(List<CatItem> categories) {
		this.categories = categories;
	}

	public MockService() {
		createRegions();
		createSettlments();
		createGoodsCategory();
	}

}
