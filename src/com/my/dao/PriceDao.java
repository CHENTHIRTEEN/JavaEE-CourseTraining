package com.my.dao;

import com.my.vo.Price;

public interface PriceDao {
	
	// findPriceById方法, 查询某个id对应的邮费
	public Price findPriceById(Integer id);
}
