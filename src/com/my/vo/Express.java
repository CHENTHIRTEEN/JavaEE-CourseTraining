package com.my.vo;

public class Express {
	// 快递id, 唯一主键
	private int id;
	// 快递单号
	private String number;
	// 客户姓名
	private String name;
	// 客户手机号
	private String phone;
	// 物流公司
	private String company;
	// 快递到站时间
	private String arrivetime;
	// 取件码
	private String pickupcode;
	// 快递状态
	private String state;
	
	public Express() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getPickupcode() {
		return pickupcode;
	}

	public void setPickupcode(String pickupcode) {
		this.pickupcode = pickupcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Express [id=" + id + ", number=" + number + ", name=" + name + ", phone=" + phone + ", company="
				+ company + ", arrivetime=" + arrivetime + ", pickupcode=" + pickupcode + ", state=" + state + "]";
	}
	
	
	
	
	
	
	
	
	
}
