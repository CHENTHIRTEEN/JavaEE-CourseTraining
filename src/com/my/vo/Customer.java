package com.my.vo;

public class Customer {
	private int id; // 用户id,唯一主键
	private String username; // 客户姓名
	private String sex; // 客户性别
	private String phone; // 客户联系电话
	private Account account; // 唯一外键,账户
	
	public Customer() {
		
	}


	/*
	 * setter、getter方法
	 */
	
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", sex=" + sex + ", phone=" + phone + ", account="
				+ account + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getSex()=" + getSex()
				+ ", getPhone()=" + getPhone() + ", getAccount()=" + getAccount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
