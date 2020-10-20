package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import application.UserSettings;
import entities.CatItem;
import entities.Member;
import entities.Proposal;
import entities.enums.ClientStatus;
import entities.enums.Gender;
import entities.enums.UserType;

public class MockService {
	private Long id = (long) 10000;
	private List<CatItem> categories = new ArrayList<CatItem>();
	private Map<String, CatItem> catByName = new HashMap<String, CatItem>();
	private Map<Long, CatItem> catById = new HashMap<Long, CatItem>();
	List<Member> clients = new ArrayList<Member>();
	List<Proposal> proposals = new ArrayList<>();
	private Random random = new Random();

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

	public List<CatItem> getRootCatsByCategory(String key, String language) {
		if (language == null)
			language = UserSettings.getChoosenLanguage();
		final String lang = language;
		List<CatItem> items = new ArrayList<CatItem>();
		catByName.forEach((k, value) -> {
			if (k.startsWith(key) && (value.getParentId() == 0) && lang.equalsIgnoreCase(value.getLanguage()))
				items.add(value);
		});
		return items;
	}

	public List<CatItem> getChildCatsByCategory(String key, Object parentObj, String language) {
		List<CatItem> result = new ArrayList<CatItem>();
		CatItem parent = null;
		if (parentObj instanceof Long) {
			Long id = (Long) parentObj;
			parent = getCatById(id);
		} else if (parentObj instanceof String) {
			String parentKey = (String) parentObj;
			parent = getCatByName(key + "-" + parentKey);
		} else if (parentObj instanceof CatItem) {
			parent = (CatItem) parentObj;
		}
		List<CatItem> items = getCatsByCategory(key, language);
		Long parentId = parent.getId();
		for (CatItem item : items)
			if (item.getParentId().equals(parentId))
				result.add(item);
		return result;

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

	public CatItem getCatByValue(String catValue, String language) {
		final String name = catValue;
		Optional<Entry<String, CatItem>> item = catByName.entrySet().stream()
				.filter(entry -> entry.getValue().getValue().equalsIgnoreCase(name)).findFirst();
		return item.get().getValue();
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
			if (item.getParentId().equals(parentId))
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

	public List<Member> getClients() {
		return clients;
	}

	public void setClients(List<Member> clients) {
		this.clients = clients;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	private CatItem addToParent(CatItem parent, String itemKey, String itemValue, String itemLanguage) {
		CatItem item = new CatItem(id++, itemKey, itemLanguage, parent.getId(), itemValue, 0);
		catByName.put(itemKey + "-" + itemValue, item);
		catById.put(item.getId(), item);
		return item;
	}

	public List<Member> getClubMembers() {
		return clients.stream().filter(mbr -> mbr.getUserType() == UserType.MEMBER).collect(Collectors.toList());
	}

	public List<Member> getClubStaff() {
		return clients
				.stream().filter(mbr -> (mbr.getUserType() == UserType.SUPERVISOR
						|| mbr.getUserType() == UserType.MODERATOR || mbr.getUserType() == UserType.STACKHOLDER))
				.collect(Collectors.toList());
	}

	private Member createMember(String name, String lastName, Gender gender, UserType user, String login,
			String... others) {
		Member p = new Member();
		p.setFirstName(name);
		p.setLastName(lastName);
		p.setGender(gender.ordinal());
		p.setUserType(user);
		p.setLogin(login);
		p.setStatus(ClientStatus.ACTIVE);
		p.setPassword("123");
		p.setId(++id);
		return p;
	}

	public void createRegions() {
		List<CatItem> result = new ArrayList<CatItem>();
		result.add(new CatItem(id++, "Country.Regions", "Северный", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Южный", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Хайфа", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Центральный", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Иудея и Самария", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Тель-Авив", "RU"));
		result.add(new CatItem(id++, "Country.Regions", "Иерусалим", "RU"));
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
		CatItem item = getCatByName("Country.Regions-Северный");
		addToParent(item, "Regions.Settlments", "Кармиэль", "RU");
		addToParent(getCatByName("Country.Regions-Северный"), "Regions.Settlments", "Кфар Манда", "RU");
		addToParent(getCatByName("Country.Regions-Северный"), "Regions.Settlments", "Нацрат Элит", "RU");

		addToParent(getCatByName("Country.Regions-Хайфа"), "Regions.Settlments", "Хайфа", "RU");
		addToParent(getCatByName("Country.Regions-Хайфа"), "Regions.Settlments", "Нешер", "RU");
		addToParent(getCatByName("Country.Regions-Хайфа"), "Regions.Settlments", "Крайот", "RU");

		addToParent(getCatByName("Country.Regions-Южный"), "Regions.Settlments", "Беэр-Шева", "RU");
		addToParent(getCatByName("Country.Regions-Южный"), "Regions.Settlments", "Ришон-ле-Цион", "RU");

		addToParent(getCatByName("Country.Regions-Центральный"), "Regions.Settlments", "Бат Ям", "RU");
		addToParent(getCatByName("Country.Regions-Центральный"), "Regions.Settlments", "Герцлия", "RU");
		addToParent(getCatByName("Country.Regions-Центральный"), "Regions.Settlments", "Кфар саба", "RU");
		addToParent(getCatByName("Country.Regions-Центральный"), "Regions.Settlments", "Рамла", "RU");

		addToParent(getCatByName("Country.Regions-Иудея и Самария"), "Regions.Settlments", "Ариэль", "RU");

		addToParent(getCatByName("Country.Regions-Иерусалим"), "Regions.Settlments", "Иерусалим", "RU");
		addToParent(getCatByName("Country.Regions-Иерусалим"), "Regions.Settlments", "Бэйт Шемеш", "RU");

		addToParent(getCatByName("Country.Regions-Тель-Авив"), "Regions.Settlments", "Тель-Авив Савидор", "RU");
		addToParent(getCatByName("Country.Regions-Тель-Авив"), "Regions.Settlments", "Питах Тиква", "RU");
		addToParent(getCatByName("Country.Regions-Тель-Авив"), "Regions.Settlments", "Яффо", "RU");

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
		CatItem item = new CatItem(id++, "Goods.Category", "Продукты питания", "RU");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Мясные продукты", "RU");
		addToParent(item, "Goods.Category", "Овощи и фрукты", "RU");
		addToParent(item, "Goods.Category", "Деликатесы", "RU");
		addToParent(item, "Goods.Category", "Алкоголь", "RU");

		item = new CatItem(id++, "Goods.Category", "Услуги", "RU");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Обучение языкам", "RU");
		addToParent(item, "Goods.Category", "Ремонт бытовой техники", "RU");
		addToParent(item, "Goods.Category", "Стрижка", "RU");

		item = new CatItem(id++, "Goods.Category", "Электроника", "RU");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Музыка и звук", "RU");
		addToParent(item, "Goods.Category", "Телевидение и компьютеры", "RU");
		addToParent(item, "Goods.Category", "Мобильные устройства", "RU");

		item = new CatItem(id++, "Goods.Category", "Товары для дома", "RU");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Кухни", "RU");
		addToParent(item, "Goods.Category", "Спальни", "RU");
		addToParent(item, "Goods.Category", "Службы", "RU");
		// ********************************************************
		item = new CatItem(id++, "Goods.Category", "Food", "EN");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Meat", "EN");
		addToParent(item, "Goods.Category", "Vegetables and fruits", "EN");
		addToParent(item, "Goods.Category", "Delicacies", "EN");
		addToParent(item, "Goods.Category", "Drinks", "EN");

		item = new CatItem(id++, "Goods.Category", "Services", "EN");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Learning of languages", "EN");
		addToParent(item, "Goods.Category", "Household appliances repair", "EN");
		addToParent(item, "Goods.Category", "Styling", "EN");

		item = new CatItem(id++, "Goods.Category", "Electronic devices", "EN");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Music and audio", "EN");
		addToParent(item, "Goods.Category", "TV and computers", "EN");
		addToParent(item, "Goods.Category", "Mobile devices", "EN");

		item = new CatItem(id++, "Goods.Category", "Goods for home", "EN");
		catByName.put("Goods.Category" + "-" + item.getValue(), item);
		addToParent(item, "Goods.Category", "Kitchens", "EN");
		addToParent(item, "Goods.Category", "Bedrooms", "EN");
		addToParent(item, "Goods.Category", "Toilets and Baths", "EN");

	}

	public List<Member> createStaff() {
		clients.add(createMember("Борис", "Шустер", Gender.MALE, UserType.SUPERVISOR, "boris", "nothing"));
		clients.add(createMember("Инна", "Шустер", Gender.FEMALE, UserType.SUPERVISOR, "inna", "nothing"));
		clients.add(createMember("Владимир", "Олевский", Gender.MALE, UserType.MODERATOR, "vlad", "nothing"));
		clients.add(createMember("Хаим", "Шапошник", Gender.MALE, UserType.STACKHOLDER, "haim", "nothing"));
		return clients;
	}

	public void createMembers() {
		Member member = createMember("Рафаэль", "Шмок", Gender.MALE, UserType.MEMBER, "rafael", "nothing");
		member.setId(20000);
		clients.add(member);
		member = createMember("Терпила", "Ле-гун", Gender.FEMALE, UserType.MEMBER, "terpila", "nothing");
		member.setId(20001);
		clients.add(member);
		member = createMember("Зион", "Розенблюм", Gender.MALE, UserType.MEMBER, "zion", "nothing");
		member.setId(20002);
		clients.add(member);
		member = createMember("Хайлу", "Недвигу", Gender.MALE, UserType.MEMBER, "hailu", "nothing");
		member.setId(20003);
		clients.add(member);
		member = createMember("Vasiliy", "Чапаев", Gender.MALE, UserType.MEMBER, "vasiliy", "nothing");
		member.setId(20004);
		clients.add(member);

	}

	private Member getRandomMember() {
		int index = random.nextInt(clients.size() - 1);
		return clients.get(index);
	}

	private List<CatItem> getRandomCategories(CatItem parent) {
		List<CatItem> result = new ArrayList<>();
		result.add(parent);
		List<CatItem> items = getChildCatsByCategory(parent.getKey(), parent, parent.getLanguage());
		CatItem rndSubCat = items.get(items.size() - 1);
		result.add(rndSubCat);
		return result;
	}

	private void createProposals() {
		CatItem haifaReg = getCatByValue("Хайфа", "RU");
		CatItem telavivReg = getCatByValue("Тель-Авив", "RU");
		CatItem foodCat = getCatByValue("Продукты питания", "RU");
		Map<String, String[]> productMap = new HashMap<>();
		String[] ajectives = "тонкая,длинная,жирная,красная,черная,баклажанная,ароматная,сушеная,вяленная".split(",");
		productMap.put("Деликатесы", "Икра,Лососина,Семга,Селедка,Кета".split(","));
		productMap.put("Мясные продукты", "Свинина,Колбаса,Рыба,Говядина,Баранина".split(","));
		productMap.put("Овощи и фрукты", "Вишня,Черешня,Клубника,Дыня,Слива,Груша,Оливка".split(","));
		productMap.put("Алкоголь", "Водка,Текила,Малага,Настойка".split(","));

		for (int i = 0; i < 20; i++) {
			LocalDate dueDate = LocalDate.now();
			dueDate.plusDays(random.nextInt(14));
			Member author = getRandomMember();
			Float randomPrice = (float) random.nextInt(100);
			List<CatItem> cats = getRandomCategories(foodCat);
			String[] lst = productMap.get(cats.get(1).getValue());
			String name = lst[random.nextInt(lst.length - 1)] + " " + ajectives[random.nextInt(ajectives.length - 1)];
			Proposal p = null;
			if (i % 2 == 0)
				p = new Proposal(id++, name, cats, haifaReg, author, randomPrice, dueDate);
			else
				p = new Proposal(id++, name, cats, telavivReg, author, randomPrice, dueDate);
			proposals.add(p);
		}
	}

	public List<CatItem> getCategories() {
		return categories;
	}

	public void setCategories(List<CatItem> categories) {
		this.categories = categories;
	}

	public MockService() {
		createGoodsCategory();
		createRegions();
		createSettlments();
		createStaff();
		createMembers();
		createProposals();
	}

}
