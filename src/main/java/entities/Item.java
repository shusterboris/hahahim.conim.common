package entities;

public class Item extends BasicEntity {
	private String language;
	private String name;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(String name, String language) {
		super();
		this.language = language;
		this.name = name;
	}

	public Item(Long id, String language, String name) {
		this(language, name);
		this.id = id;
	}
}
