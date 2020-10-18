package entities.enums;

/**
 * 
 * @author Одиссей Статус тендера: INIT - создан инициатором; REJECTED -
 *         отвергнут модератором; REVIEWED - принято модератором PUBLISHED -
 *         опубликован для подачи ценовых предложений; ACCEPTED - объявлен
 *         победитель; SAIL - идут продажи; ARCHIVE - завершен
 */
public enum TenderStatus {
	INIT, REJECTED, REVIEWED, PUBLISHED, ACCEPTED, SAIL, ARCHIVE;

	public String getMessageKey() {
		return Class.class.getSimpleName() + "." + name();
	}
}
