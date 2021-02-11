package enums;

public enum ClientStatus {
	NEW, ACTIVE, FROZEN, SUSPENDED, ARCHIVE;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

	public static String getMessageKeyByNumber(int key) {
		for (ClientStatus status : ClientStatus.values()) {
			if (status.ordinal() == key)
				return status.getMessageKey();
		}
		return "ClientStatus.INIT";
	}

	public static ClientStatus getStatusByMessage(String key) {
		for (ClientStatus status : ClientStatus.values()) {
			if (key.equals(status.getMessageKey()))
				return status;
		}
		return ClientStatus.NEW;
	}

	public static int getOrdinalByMessage(String key) {
		return getStatusByMessage(key).ordinal();
	}

}
