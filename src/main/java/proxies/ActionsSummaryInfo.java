package proxies;

import java.io.Serializable;
import java.math.BigInteger;

public class ActionsSummaryInfo implements Serializable {
	private static final long serialVersionUID = -7874307930056569383L;

	private String settlement = "";
	private String region = "";
	private String goodsCategory;
	private String goodsName;
	private String measure;
	public Float quantity = (float) 0;
	public Float price = (float) 0;
	public String deliveryAddress = "";
	private String firstName;
	private String lastName = "";
	private String phone;
	private Long intentId = (long) 0;
	private Long memberId = (long) 0;
	private Long proposalId = (long) 0;
	private Long supplierId = (long) 0;

	public static ActionsSummaryInfo getInstanse(Object[] obj) {
		ActionsSummaryInfo inst = new ActionsSummaryInfo();
		inst.setRegion(obj[0] == null || "null".equals(obj[0]) ? "" : (String) obj[0]);
		inst.setSettlement(obj[1] == null || "null".equals(obj[1]) ? "" : (String) obj[1]);
		inst.setGoodsCategory((String) obj[2]);
		inst.setGoodsName((String) obj[3]);
		inst.setMeasure((String) obj[4]);
		inst.setDeliveryAddress((String) obj[7]);
		inst.setFirstName((String) obj[8]);
		inst.setLastName((String) obj[9]);
		inst.setPhone((String) obj[10]);
		if (obj.length > 14) {
			// если результат запроса содержит дополнительные колонки - это количество и
			// сумма по группе
			Double dbl = (Double) obj[15];
			inst.setQuantity(dbl.floatValue());
			dbl = (Double) obj[16];
			inst.setPrice(dbl.floatValue());
		} else {// иначе берем цену и количество
			inst.setQuantity((Float) obj[5]);
			inst.setPrice((Float) obj[6]);
		}
		inst.setIntentId(parseObjToLong(obj[11]));
		inst.setMemberId(parseObjToLong(obj[12]));
		inst.setProposalId(parseObjToLong(obj[13]));
		inst.setSupplierId(parseObjToLong(obj[14]));
		return inst;
	}

	private static Long parseObjToLong(Object obj) {
		try {
			BigInteger bi = (BigInteger) obj;
			return bi.longValue();
		} catch (Exception e) {
			return (long) 0;
		}
	}

	public String mainInfo() {
		String money = String.format("%.2f ₪ x %.2f  %s = %.2f ₪, ", price, quantity, measure, price * quantity);
		return money.concat(getMemberName()).concat(" ").concat(deliveryAddress != null ? deliveryAddress : "");
	}

	public String toString() {
		String money = String.format("%.2f ₪ x %.2f  %s = %.2f ₪, ", price, quantity, measure, price * quantity);
		return goodsName.concat(" ").concat(money).concat(getMemberName()).concat(" ")
				.concat(deliveryAddress != null ? deliveryAddress : "");
	}

	public String getMemberName() {
		if ("".equals(lastName))
			return firstName;
		return lastName.concat(" ").concat(firstName);
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getIntentId() {
		return intentId;
	}

	public void setIntentId(Long intentId) {
		this.intentId = intentId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getProposalId() {
		return proposalId;
	}

	public void setProposalId(Long proposalId) {
		this.proposalId = proposalId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

}
