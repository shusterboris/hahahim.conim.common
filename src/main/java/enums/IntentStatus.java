package enums;

public enum IntentStatus {
	NEW, ACCEPTED, CANCELED_BY_MEMBER, CANCELED, WAITING, ARCHIVE;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

	public static String getMessageKeyByNumber(int key) {
		for (IntentStatus status : IntentStatus.values()) {
			if (status.ordinal() == key)
				return status.getMessageKey();
		}
		return "IntentStatus.NEW";
	}

	public static IntentStatus getStatusByMessage(String key) {
		for (IntentStatus status : IntentStatus.values()) {
			if (key.equals(status.getMessageKey()))
				return status;
		}
		return IntentStatus.NEW;
	}

	public static int getOrdinalByMessage(String key) {
		return getStatusByMessage(key).ordinal();
	}

}
