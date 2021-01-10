package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my.vo.OrderInfo;
import com.my.vo.ShippingOrder;
import com.my.vo.UpOrderInfo;

@Repository
public interface OrderDao {
	
	// 接口方法, 用于获取所有客户订单信息
	public List<OrderInfo> showOrderList(String phone);
	
	// showOrderListCount方法, 用于获取订单数
	public int showOrderListCount(String phone);
	
	// addOrder方法， 用于添加订单
	public int addOrder(OrderInfo orderInfo);
	
	// addUpOrder方法, 用于添加未处理的订单信息
	public int addUpOrder(UpOrderInfo upOrderInfo);
	
	// findUpOrderInfoById方法, 用于查询未处理的订单信息以供修改
	public UpOrderInfo findUpOrderInfoById(Integer id);
	
	// findInfoIdById方法, 查询订单对应的未处理信息
	public int findInfoIdById(Integer id);
	
	// updateUpOrderInfo方法 修改未经过预处理的订单信息
	public int updateUpOrderInfo(UpOrderInfo upOrderInfo);
	
	// updateOrderInfoById方法 修改经过预处理的订单信息
	public int updateOrderInfoById(OrderInfo orderInfo);
	
	// deleteOrderById方法 用于删除订单
	public int deleteOrderById(Integer id);
}
