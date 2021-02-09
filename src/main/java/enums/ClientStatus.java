package enums;

public enum ClientStatus {
	NEW, ACTIVE, FROZEN, SUSPENDED, ARCHIVE;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}
}
