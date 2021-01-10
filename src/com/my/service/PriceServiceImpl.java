package com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.PriceDao;
import com.my.vo.Price;

@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceDao priceDao;
	
	@Override
	public Price findPriceById(Integer id) {
		Price price = priceDao.findPriceById(id);
		return price;
	}

}
