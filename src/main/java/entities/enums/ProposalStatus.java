package entities.enums;

/**
 * 
 * @author ������� ������ �������: INIT - ������ �����������; REJECTED -
 *         ��������� �����������; REVIEWED - ������� ����������� PUBLISHED -
 *         ����������� ��� ������ ������� �����������; ACCEPTED - ��������
 *         ����������; SAIL - ���� �������; ARCHIVE - ��������
 */
public enum ProposalStatus {
	INIT, REJECTED, REVIEWED, PUBLISHED, ACCEPTED, SAIL, ARCHIVE;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}