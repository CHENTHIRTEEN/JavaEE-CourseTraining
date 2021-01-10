package com.my.dao;


import org.springframework.stereotype.Repository;

import com.my.vo.Account;

@Repository
public interface AccountDao {
	// 接口方法loginByName, 用于用户登录
	public Account loginByName(String loginname);
	
	// 接口方法customerRegister, 用于用户注册
	public int customerRegister(Account account);
	
	// isAccountExistence方法, 用于判断要注册的账户是否已经存在
	public String isAccountExistence(String loginname);
	
	// changeCusPassword方法, 用于修改用户登录密码
	public int changeCusPassword(Account account);
	
}
