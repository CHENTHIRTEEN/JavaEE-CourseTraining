package com.my.vo;

// 未经处理分订单信息， 用于在controller层处理前端获取的数据
public class UpOrderInfo {
	private int id;
	// 快递公司
	private String express;
	// 寄件人姓名
	private String sender;
	// 寄件人手机号
	private String senderphone;
	// 寄件人所在省份
	private String senderprovice;
	//寄件人所在城市
	private String sendercity;
	// 寄件人所在区
	private String senderdistrict;
	// 寄件人具体地址
	private String address;
	// 货物重量
	private String weight;
	/*
	 * 收件人属性与寄件人结构相同
	 */
	private String addressee;
	private String addresseephone;
	private String addresseeprovice;
	private String addresseecity;
	private String addresseedistrict;
	private String adaddress;
	
	/*
	 *  setter...getter方法
	 */
	public String getWeight() {
		return weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public UpOrderInfo()
	{
		
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderphone() {
		return senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public String getSenderprovice() {
		return senderprovice;
	}

	public void setSenderprovice(String senderprovice) {
		this.senderprovice = senderprovice;
	}

	public String getSendercity() {
		return sendercity;
	}

	public void setSendercity(String sendercity) {
		this.sendercity = sendercity;
	}

	public String getSenderdistrict() {
		return senderdistrict;
	}

	public void setSenderdistrict(String senderdistrict) {
		this.senderdistrict = senderdistrict;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getAddresseephone() {
		return addresseephone;
	}

	public void setAddresseephone(String addresseephone) {
		this.addresseephone = addresseephone;
	}

	public String getAddresseeprovice() {
		return addresseeprovice;
	}

	public void setAddresseeprovice(String addresseeprovice) {
		this.addresseeprovice = addresseeprovice;
	}

	public String getAddresseecity() {
		return addresseecity;
	}

	public void setAddresseecity(String addresseecity) {
		this.addresseecity = addresseecity;
	}

	public String getAddresseedistrict() {
		return addresseedistrict;
	}

	public void setAddresseedistrict(String addresseedistrict) {
		this.addresseedistrict = addresseedistrict;
	}

	public String getAdaddress() {
		return adaddress;
	}

	public void setAdaddress(String adaddress) {
		this.adaddress = adaddress;
	}

	@Override
	public String toString() {
		return "UpOrderInfo [id=" + id + ", express=" + express + ", sender=" + sender + ", senderphone=" + senderphone
				+ ", senderprovice=" + senderprovice + ", sendercity=" + sendercity + ", senderdistrict="
				+ senderdistrict + ", address=" + address + ", weight=" + weight + ", addressee=" + addressee
				+ ", addresseephone=" + addresseephone + ", addresseeprovice=" + addresseeprovice + ", addresseecity="
				+ addresseecity + ", addresseedistrict=" + addresseedistrict + ", adaddress=" + adaddress + "]";
	}

	
	
}
