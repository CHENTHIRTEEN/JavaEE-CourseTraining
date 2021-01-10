package com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.AccountDao;
import com.my.vo.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	// 获取AccountDao类, 以调用Dao层方法
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account loginByName(String loginname) {
		// 返回搜索到的account对象
		Account account = accountDao.loginByName(loginname);
		return account;
	}

	@Override
	public int customerRegister(Account account) {
		int row = accountDao.customerRegister(account);
		return row;
	}

	@Override
	public String isAccountExistence(String loginname) {
		String flag = accountDao.isAccountExistence(loginname);
		return flag;
	}

	@Override
	public int changeCusPassword(Account account) {
		int row = accountDao.changeCusPassword(account);
		return row;
	}

}
