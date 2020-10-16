package entities.enums;

public enum ClientStatus {
	POTENTIAL, ACTIVE, FROZEN, SUSPENDED, ARCHIVE;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}

}
