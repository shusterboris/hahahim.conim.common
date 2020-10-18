package entities.enums;

/**
 * 
 * @author ������� ������ �������: INIT - ������ �����������; REJECTED -
 *         ��������� �����������; REVIEWED - ������� ����������� PUBLISHED -
 *         ����������� ��� ������ ������� �����������; ACCEPTED - ��������
 *         ����������; SAIL - ���� �������; ARCHIVE - ��������
 */
public enum TenderStatus {
	INIT, REJECTED, REVIEWED, PUBLISHED, ACCEPTED, SAIL, ARCHIVE;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}
