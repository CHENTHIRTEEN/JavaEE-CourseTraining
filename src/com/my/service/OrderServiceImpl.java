package com.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.OrderDao;
import com.my.vo.OrderInfo;
import com.my.vo.ShippingOrder;
import com.my.vo.UpOrderInfo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{


	@Autowired
	private OrderDao orderDao;

	@Override
	public List<OrderInfo> showOrderList(String phone) {
		// TODO Auto-generated method stub
		return this.orderDao.showOrderList(phone);
	}

	@Override
	public int showOrderListCount(String phone) {
		// TODO Auto-generated method stub
		return this.orderDao.showOrderListCount(phone);
	}

	@Override
	public int addOrder(OrderInfo orderInfo) {
		int row = orderDao.addOrder(orderInfo);
		return row;
	}


	@Override
	public int addUpOrder(UpOrderInfo upOrderInfo) {
		int row = orderDao.addUpOrder(upOrderInfo);
		return row;
	}

	@Override
	public UpOrderInfo findUpOrderInfoById(Integer id) {
		UpOrderInfo upOrder = orderDao.findUpOrderInfoById(id);
		return upOrder;
	}

	@Override
	public int findInfoIdById(Integer id) {
		int info_id = orderDao.findInfoIdById(id);
		return info_id;
	}

	@Override
	public int updateUpOrderInfo(UpOrderInfo upOrderInfo) {
		int row = orderDao.updateUpOrderInfo(upOrderInfo);
		
		return row;
	}

	@Override
	public int updateOrderInfoById(OrderInfo orderInfo) {
		int row = orderDao.updateOrderInfoById(orderInfo);
		return row;
	}

	@Override
	public int deleteOrderById(Integer id) {
		int row = orderDao.deleteOrderById(id);
		return row;
	}



}
