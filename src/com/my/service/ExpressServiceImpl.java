package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.ExpressDao;
import com.my.vo.Express;

@Service
@Transactional
public class ExpressServiceImpl implements ExpressService{

	
	@Autowired
	private ExpressDao expressDao;
	
	@Override
	public List<Express> showExpressList(String phone) {
		
		return this.expressDao.showExpressList(phone);
	}

	@Override
	public int showExpressListCount(String phone) {
		// TODO Auto-generated method stub
		return this.expressDao.showExpressListCount(phone);
	}

}
