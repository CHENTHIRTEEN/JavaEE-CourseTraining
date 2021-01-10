package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.vo.Express;

@Repository
public interface ExpressDao {
	// showExpressList方法, 通过用户手机号查询快递列表
	public List<Express> showExpressList(String phone);
	// showExpressListCount方法, 获取用户总快递数量
	public int showExpressListCount(String phone);
}
