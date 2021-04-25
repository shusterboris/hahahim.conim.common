package enums;

public enum ProposalStatus {
	INIT, REJECTED, REVIEWED, PUBLISHED, COMPLETED, SAIL, ARCHIVE;

	public String getMessageKey() {
		return getClass().getSimpleName() + "." + name();
	}

	public static String getMessageKeyByNumber(int key) {
		for (ProposalStatus status : ProposalStatus.values()) {
			if (status.ordinal() == key)
				return status.getMessageKey();
		}
		return "ProposalStatus.INIT";
	}

	public static int getOrdinalByMessage(String key) {
		for (ProposalStatus status : ProposalStatus.values()) {
			if (key.equals(status.getMessageKey()))
				return status.ordinal();
		}
		return 0;
	}

}
