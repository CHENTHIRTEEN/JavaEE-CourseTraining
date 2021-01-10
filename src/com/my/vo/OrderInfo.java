package com.my.vo;

import java.util.Date;

public class OrderInfo {
	// 订单id
	private int id;
	// 快递始发地
	private String origin;
	// 快递终点
	private String end;
	// 邮费
	private double price;
	// 订单状态
	private String state;
	// 寄件人
	private String sender;
	// 收件人
	private String addressee;
	// 寄件人手机号
	private String senderphone;
	// 收件人手机号
	private String addresseephone;
	// 订单创建日期
	private Date createtime;
	// 订单对应的未处理信息编号
	private int info_id;
	
	


	public OrderInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getSenderphone() {
		return senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public String getAddresseephone() {
		return addresseephone;
	}

	public void setAddresseephone(String addresseephone) {
		this.addresseephone = addresseephone;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

//	public OrderInfo() {
//		
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", origin=" + origin + ", end=" + end + ", price=" + price + ", state=" + state
				+ ", sender=" + sender + ", addressee=" + addressee + ", senderphone=" + senderphone
				+ ", addresseephone=" + addresseephone + ", createtime=" + createtime + ", info_id=" + info_id + "]";
	}


	

	
	
}
