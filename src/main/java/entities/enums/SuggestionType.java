package entities.enums;

public enum SuggestionType {
	TENDER, ACTION;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}
