package enums;

public enum ClientStatus {
	NEW, CANDIDATE, ACTIVE, FROZEN, SUSPENDED, ARCHIVE;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}
	// POTENTIAL - это новый пользователь, возможно, свежезарегистрированный
	// CANDIDATE - проверенный модератором, например, может принять участие в 3-4 акциях
}
