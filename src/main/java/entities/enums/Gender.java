package entities.enums;

public enum Gender {
	FEMALE, MALE, UNSIGNED;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}
