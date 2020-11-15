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
import entities.ClientNotification;
import proxies.Address;
import proxies.BusinessPartner;
import proxies.Contacts;
import proxies.Member;
import proxies.Proposal;
import proxies.Store;
import proxies.Person;
import proxies.PriceProposal;

import entities.enums.*;
public class MockService {
	private Long id = (long) 10000;
	private List<CatItem> categories = new ArrayList<CatItem>();
	private Map<String, CatItem> catByName = new HashMap<String, CatItem>();
	private Map<Long, CatItem> catById = new HashMap<Long, CatItem>();
	List<Member> clients = new ArrayList<Member>();
	List<Proposal> proposals = new ArrayList<>();
	List<CatItem> measures = new ArrayList<>();
	List<Proposal> actions = new ArrayList<>();
	private Random random = new Random();
	private BusinessPartner partner;

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
	public List<Proposal> getActions() {
		return actions;
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
	private CatItem addToParentwithImage(CatItem parent, String itemKey, String itemValue, String itemLanguage,String image) {
		CatItem item=addToParent(parent,itemKey,itemValue,itemLanguage);
		item.setAddValue(image);
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

	public Member getUser(String login, String pasword) {
		return clients.stream()
				.filter(mbr -> mbr.getLogin().equals(login) && 
						mbr.getPassword().equals(pasword))
				.findAny()
				.orElse(null);		
	}
	
	public List<ClientNotification> getNotifications()
	{
		ArrayList<ClientNotification> notifList = new ArrayList<ClientNotification>();
		
		notifList.add(new ClientNotification("First title", "First text"));
		notifList.add(new ClientNotification("Second title", "Second text"));
		
		return notifList;
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
	
	private void createMeasures() {
		measures.add(new CatItem(id++, "Measures", "кг", "RU"));
		measures.add(new CatItem(id++, "Measures", "шт", "RU"));
		measures.add(new CatItem(id++, "Measures", "100 г", "RU"));
		measures.add(new CatItem(id++, "Measures", "л", "RU"));
		measures.add(new CatItem(id++, "Measures", "kg", "EN"));
		measures.add(new CatItem(id++, "Measures", "piece", "EN"));
		measures.add(new CatItem(id++, "Measures", "100 g", "EN"));
		measures.add(new CatItem(id++, "Measures", "liter", "EN"));

		for (CatItem item : measures) {
			catByName.put("Measures" + "-" + item.getValue(), item);
			catById.put(item.getId(), item);
		}
		
	}

	private Address createAddress(String region, String street,String sity) {
		Address a=new Address();
		a.setRegion(region);
		a.setStreetAddress(street);
		a.setSettlment(sity);
		return a;
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
		addToParentwithImage(item, "Goods.Category", "Мясные продукты", "RU","Salami.png");
		addToParentwithImage(item, "Goods.Category", "Овощи и фрукты", "RU","fruits.png");
		addToParentwithImage(item, "Goods.Category", "Деликатесы", "RU","seefoods.png");
		addToParentwithImage(item, "Goods.Category", "Алкоголь", "RU","wine.png");
		addToParentwithImage(item, "Goods.Category", "Сладости", "RU","sw.png");
		addToParentwithImage(item, "Goods.Category", "Сыр", "RU","sw.png");

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
		addToParentwithImage(item, "Goods.Category", "Meat", "EN","Salami.png");
		addToParentwithImage(item, "Goods.Category", "Vegetables and fruits", "EN","fruits.png");
		addToParentwithImage(item, "Goods.Category", "Delicacies", "EN","seefoods.png");
		addToParentwithImage(item, "Goods.Category", "Drinks", "EN","wine.png");
		addToParentwithImage(item, "Goods.Category", "Sweets", "EN","sw.png");
		addToParentwithImage(item, "Goods.Category", "Cheese", "EN","sw.png");

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
		clients.add(createMember("Борис", "Шустер", Gender.MALE, UserType.SUPERVISOR, "boris", "123"));
		clients.add(createMember("Инна", "Шустер", Gender.FEMALE, UserType.SUPERVISOR, "inna", "123"));
		clients.add(createMember("Владимир", "Олевский", Gender.MALE, UserType.MODERATOR, "vlad", "123"));
		clients.add(createMember("Хаим", "Шапошник", Gender.MALE, UserType.STACKHOLDER, "haim", "123"));
		return clients;
	}

	public void createMembers() {
		Member member = createMember("Арон", "Беседер", Gender.MALE, UserType.PARTNER, "aron", "123");
		member.setId(20000);
		clients.add(member);
		member = createMember("Терпила", "Ле-гун", Gender.FEMALE, UserType.MEMBER, "terpila", "123");
		member.setId(20001);
		clients.add(member);
		member = createMember("Зион", "Розенблюм", Gender.MALE, UserType.MEMBER, "zion", "123");
		member.setId(20002);
		clients.add(member);
		member = createMember("Хайлу", "Недвигу", Gender.MALE, UserType.MEMBER, "hailu", "123");
		member.setId(20003);
		clients.add(member);
		member = createMember("Vasiliy", "Чапаев", Gender.MALE, UserType.MEMBER, "vasiliy", "123");
		member.setId(20004);
		clients.add(member);
		member = createMember("Моше", "Цибулински", Gender.MALE, UserType.PARTNER, "moshe", "123");
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

	public Proposal createProposal(Long id, String name, List<CatItem> categories, CatItem region, Member author, Float price, LocalDate dueDate) {
		Proposal pp=new Proposal();
		 	 pp.setId(id) ;
		     pp.setName(name); 
			  pp.setCategories(categories); 
			 pp.setRegion(region); 
			  pp.setInitiator( author);
			  pp.setPrice(price); 
			  pp.setDueDate(dueDate); 
			  return pp;
	}		  
			  
	private void createProposals() {
		CatItem haifaReg = getCatByValue("Хайфа", "RU");
		CatItem telavivReg = getCatByValue("Тель-Авив", "RU");
		CatItem foodCat = getCatByValue("Продукты питания", "RU");
		Map<String, String[]> productMap = new HashMap<>();
		String[] ajectives = "свежая,недорогая,эксклюзивная,традиционная,деликатесная,особая, вкусная".split(",");
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
				p = createProposal(id++, name, cats, haifaReg, author, randomPrice, dueDate);
			else
				p = createProposal(id++, name, cats, telavivReg, author, randomPrice, dueDate);
			p.setMaxPrice(random.nextFloat());
			p.setStatus("ProposalStatus.PUBLISHED");
			p.setWinner("Сеть магазинов 'Мама'");
			p.setWinnerId((long)999);
			p.setMeasure(measures.get(random.nextInt(measures.size()-1)));
			proposals.add(p);
		}
	} 

	public PriceProposal createPriceProposal(Long proposalId,Float price,Float quantity ){
		PriceProposal pp=new PriceProposal();
		pp.setProposalId(proposalId);
		pp.setPrice(price);
		pp.setQuantity(quantity);
		return pp;
	}

	public List<CatItem> getCategories() {
		return categories;
	}

	public void setCategories(List<CatItem> categories) {
		this.categories = categories;
	}

	private void createActions() {
		ArrayList<Address> stores=new ArrayList<Address>();
		stores.add(createAddress("Тель-Авив","ул. Герцль 60","Бат-Ям"));
		stores.add(createAddress("Тель-Авив","ул. Жаботински 133","Рамат-Ган"));
		CatItem telavivReg = getCatByValue("Тель-Авив", "RU");
		
		CatItem[] foodcat =  new CatItem[6];
		foodcat[0]=getCatByValue("Мясные продукты", "RU");
		foodcat[1]=getCatByValue("Сыр", "RU");
		foodcat[2]=getCatByValue( "Алкоголь", "RU");
		foodcat[3]=getCatByValue("Овощи и фрукты", "RU");
		foodcat[4]=getCatByValue( "Деликатесы", "RU");
		foodcat[5]=getCatByValue( "Сладости", "RU");
		
		String[] names=new String[6];
		names[0]="колбаса вареная";
		names[1]="сыр моцарелла";
		names[2]="пиво Гиннес";
		names[3]="клубника свежая";
		names[4]="икра красная";
		names[5]="шоколад ";
		
		for (int i = 0; i < names.length; i++) {
			LocalDate dueDate = LocalDate.now();
			dueDate.plusDays(random.nextInt(14));
			Member author = getRandomMember();
		    String name=names[i];
		    Long id=(long) (100+i);
		    ArrayList<PriceProposal> variants=new ArrayList<PriceProposal>();
		    variants.add(createPriceProposal(id,new Float(300),new Float(3)) );
		    variants.add(createPriceProposal(id,new Float(250),new Float(5)) );
		    variants.add(createPriceProposal(id,new Float(200),new Float(6)) );
		    ArrayList<CatItem> cats=new ArrayList<CatItem>();
		    cats.add(getCatByValue("Продукты питания", "RU"));
		    cats.add(foodcat[i]);
		    Proposal ac = createProposal(id, name, cats, telavivReg, author, new Float(200), dueDate);
		    ac.setPriceProposals(variants);
		    ac.setStores(stores);
		    ac.setMeasure(new CatItem((long) 800+i, "Measure", "кг", "RU"));
		    if (i % 2 == 0) {
			    ac.setWinner("Бердычевские пончики");
			    ac.setWinnerId((long)998);
		    }else {
			    ac.setWinner("Мирра и дети");
			    ac.setWinnerId((long)997);
		    }
		  
		    List<String> ps=new ArrayList<String>();
		    ps.add(foodcat[i].getAddValue());
			ac.setPhotos(ps);
		    actions.add(ac);
		}
		    
	}
	
	private void createPartner() {
		partner=new BusinessPartner("",createAddress("Тель-Авив","ул. Гистадрут 20","Бней-брак"), (long) 0);
		partner.setId(11111);
		partner.setName("Мааданей Росман");
		partner.setFullName("Сеть Мааданей Росман");
		ArrayList<Store> stores=new ArrayList<Store>();
		stores.add(new Store("",createAddress("Хайфа","ул. Герцль 60","Хайфа"),partner.getId()));
		stores.add(new Store("",createAddress("Тель-Авив","ул. Жаботински 133","Рамат-Ган"),partner.getId()));
		partner.setStores(stores);
		ArrayList<Contacts> allContacts=new ArrayList<Contacts>();
		allContacts.add(new Contacts("Михаил","Коэн","050-9999-88-77"));
		allContacts.add(new Contacts("Давид","Левин", "050-9999-88-77"));
		partner.setContacts(allContacts);
		
	}
	
	public MockService() {
		createGoodsCategory();
		createRegions();
		createMeasures();
		createSettlments();
		createStaff();
		createMembers();
		createProposals();
		createActions();
		createPartner();
		
	}
		public BusinessPartner getPartnerById(Long id) {
		return partner;
	}
	
	public List<CatItem> getAllCategories(String language){
		if (language == null)
			language = UserSettings.getChoosenLanguage();
		final String lang = language;
		List<CatItem> items = new ArrayList<CatItem>();
		catByName.forEach((k, value) -> {
			if (lang.equalsIgnoreCase(value.getLanguage()))
				items.add(value);
		});
		return items;

	}
	

}
