package com.my.vo;

public class ShippingOrder {
	// 配送id, 唯一主键
	private int id;
	// 客户姓名
	private String username;
	// 客户手机号
	private String phone;
	// 快递公司
	private String express;
	// 取件码
	private String pickupcode;
	// 配送地址
	private String address;
	
	
	public ShippingOrder() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getExpress() {
		return express;
	}


	public void setExpress(String express) {
		this.express = express;
	}


	public String getPickupcode() {
		return pickupcode;
	}


	public void setPickupcode(String pickupcode) {
		this.pickupcode = pickupcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "ShippingOrder [id=" + id + ", username=" + username + ", phone=" + phone + ", express=" + express
				+ ", pickupcode=" + pickupcode + ", address=" + address + "]";
	}
	
	
	
	
}
