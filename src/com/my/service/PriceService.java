package com.my.service;

import com.my.vo.Price;

public interface PriceService {
	
	// findPriceById方法, 查询某个id对应的邮费
		public Price findPriceById(Integer id);
}
