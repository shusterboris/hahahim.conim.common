package enums;

public enum MemberStatus {
	SIMPLE, GOLD, PLATINUM;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

	public static String getMessageKeyByNumber(int key) {
		for (MemberStatus status : MemberStatus.values()) {
			if (status.ordinal() == key)
				return status.getMessageKey();
		}
		return "MemberStatus.INIT";
	}

	public static MemberStatus getStatusByMessage(String key) {
		for (MemberStatus status : MemberStatus.values()) {
			if (key.equals(status.getMessageKey()))
				return status;
		}
		return MemberStatus.SIMPLE;
	}

	public static int getOrdinalByMessage(String key) {
		return getStatusByMessage(key).ordinal();
	}

}
