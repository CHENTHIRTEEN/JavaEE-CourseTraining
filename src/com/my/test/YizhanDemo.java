package com.my.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.dao.OrderDao;
import com.my.vo.OrderInfo;
import com.my.vo.UpOrderInfo;

class YizhanDemo {
	@Autowired
	private OrderDao orderDao;
	
	
	
//	private ApplicationContext applicatonContext;
//	@Before
//	public void setUp() throws Exception{
//		String configLocation = "classpath:applicationContext.xml";
//		applicatonContext = new ClassPathXmlApplicationContext(configLocation);
//	}


	@Ignore
	@Test
	void testAddUpOrderInfo() {
//		UserMapper userMapper = (UserMapper)applicatonContext.getBean("userMapper");
//
//		User user = userMapper.selectByPrimaryKey(1);
//		System.out.println(user);
		//OrderDao orderDao = (OrderDao) applicatonContext.getBean("orderDao");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		
		
		UpOrderInfo up = new UpOrderInfo();
		up.setExpress("1");
		up.setSender("陈冰");
		up.setSenderphone("17315387719");
		up.setSenderprovice("江苏省");
		up.setSendercity("常州市");
		up.setSenderdistrict("武进区");
		up.setAddress("常州信息职业技术学院");
		up.setWeight("5");
		up.setAddressee("戚杰");
		up.setAddresseephone("123456789");
		up.setAddresseeprovice("江苏省");
		up.setAddresseecity("无锡市");
		up.setAddresseedistrict("梁溪区");
		up.setAdaddress("南新苑五区");
		orderDao.addUpOrder(up);
		
		
		
	}
	
	
	@Test
	void addOrderTest() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setSender("陈冰");
		orderInfo.setOrigin("江苏省常州市武进区常州信息职业技术学院");
		orderInfo.setSenderphone("17315387719");
		orderInfo.setEnd("江苏省无锡市梁溪区新苏新村22-602");
		orderInfo.setAddresseephone("15190287915");
		orderInfo.setAddressee("陈冰");
		orderInfo.setState("已发出");
		orderInfo.setCreatetime(new Date());
		orderDao.addOrder(orderInfo);
	}
	

}
