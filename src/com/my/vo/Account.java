package com.my.vo;

public class Account {
	// 用户id，唯一主键
	private int id;
	// 用户真实姓名
	private String name;
	// 用户登录时的账户名
	private String loginname;
	// 登录密码
	private String password;
	// 用户手机号用于查询
	private String phone;
	
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

	public Account() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", loginname=" + loginname + ", password=" + password + "]";
	}
	
	
	
	
}
