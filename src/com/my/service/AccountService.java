package com.my.service;

import com.my.vo.Account;

public interface AccountService {

	public Account loginByName(String loginname);
	
	public int customerRegister(Account account);
	
	public String isAccountExistence(String loginname);
	
	public int changeCusPassword(Account account);
}
