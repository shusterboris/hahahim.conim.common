package entities.enums;

public enum UserType {
	MEMBER, PARTNER, MODERATOR, SUPERVISOR, STACKHOLDER;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}
