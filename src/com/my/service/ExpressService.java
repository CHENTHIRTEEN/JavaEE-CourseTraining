package com.my.service;

import java.util.List;

import com.my.vo.Express;

public interface ExpressService {

	// showExpressList方法, 通过用户手机号查询快递列表
	public List<Express> showExpressList(String phone);
	// showExpressListCount方法, 通过手机号查询用户总快递数量
	public int showExpressListCount(String phone);
}
