package enums;

public enum UserType {
	MEMBER, PARTNER, MODERATOR, SUPERVISOR, STACKHOLDER;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

	public static String getMessageKeyByNumber(int key) {
		for (UserType status : UserType.values()) {
			if (status.ordinal() == key)
				return status.getMessageKey();
		}
		return "UserType.INIT";
	}

	public static UserType getTypeByMessage(String key) {
		for (UserType status : UserType.values()) {
			if (key.equals(status.getMessageKey()))
				return status;
		}
		return UserType.MEMBER;
	}

	public static int getOrdinalByMessage(String key) {
		return getTypeByMessage(key).ordinal();
	}

}
