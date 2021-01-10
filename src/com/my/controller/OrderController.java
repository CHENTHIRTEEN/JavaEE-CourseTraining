package com.my.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.service.OrderService;
import com.my.service.PriceService;
import com.my.utils.BaseUtil;
import com.my.utils.JsonUtil;
import com.my.vo.Account;
import com.my.vo.Express;
import com.my.vo.OrderInfo;
import com.my.vo.Price;
import com.my.vo.ShippingOrder;
import com.my.vo.UpOrderInfo;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private PriceService priceService;


	@RequestMapping("/showOrderList")
	public String showOrderList() {
		return "expressManage/orderList";
	}

	@RequestMapping(value="/getOrderList")
	public void getOrderList(HttpServletRequest request,
			HttpServletResponse response,
			Express express,Integer page,Integer limit) {
		System.out.println("Hello Order");
		Account account = (Account) request.getSession().getAttribute("account");
		String phone = account.getPhone();
		System.out.println(phone);
		if(page == null){
			page = 1;
		}
		if(limit == null){
			limit = 10;
		}
		BaseUtil baseUtil = new BaseUtil();
		Integer totalCount = orderService.showOrderListCount(phone);
		List<OrderInfo> orderList = orderService.showOrderList(phone);
		//		List<OrderInfo> list = null;
		//		for (OrderInfo o : orderList) {
		//			String sender = o.getOrigin();
		//			int index1 = sender.indexOf("市");
		//			sender = sender.substring(0, index1);
		//			o.setOrigin(sender);
		//			String addressee = o.getAddressee();
		//			int index2 = addressee.indexOf("市");
		//			addressee = addressee.substring(0, index1);
		//			o.setOrigin(addressee);
		//			list.add(o);
		//		}


		BaseUtil.output(response, JsonUtil.buildJsonByTotalCount(orderList, totalCount));

	}


	// 转到添加订单页面
	@RequestMapping(value="/toAddOrder", method=RequestMethod.GET)
	public String toAddOrder() {
		return "expressManage/addOrder";
	}

	// 添加订单功能实现
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public void addOrder(HttpServletResponse response, UpOrderInfo upOrderInfo) {
		BaseUtil baseUtil = null;
		System.out.println(upOrderInfo);
		orderService.addUpOrder(upOrderInfo);
		OrderInfo orderInfo = orderInfoProcessed(upOrderInfo);
		orderService.addOrder(orderInfo);
		baseUtil.output(response,JsonUtil.buildFalseJson(0, "添加成功！"));
	}
	
	// 跳转到修改订单页面
	@RequestMapping(value="toUpdateOrder")
	public ModelAndView updateOrder(ModelAndView mv, Integer id) {
		System.out.println("id => " + id);
		int info_id = orderService.findInfoIdById(id);
		UpOrderInfo upOrder = orderService.findUpOrderInfoById(info_id);
		System.out.println(upOrder.getId());
		mv.addObject("upOrder", upOrder);
		mv.setViewName("expressManage/updateOrder");
		return mv;
	}
	
	// 编辑订单信息
	@RequestMapping(value="/updateOrder", method=RequestMethod.POST)
	public void updateUser(HttpServletResponse response, UpOrderInfo upOrderInfo){
		BaseUtil baseUtil = null;
		System.out.println(upOrderInfo);
		orderService.updateUpOrderInfo(upOrderInfo);
		OrderInfo orderInfo = orderInfoProcessed(upOrderInfo);
		System.out.println(orderInfo);
		orderService.updateOrderInfoById(orderInfo);
		baseUtil.output(response,JsonUtil.buildFalseJson(0, "修改成功！"));
		//output(response,JsonUtil.buildFalseJson(0, "编辑成功！"));
		
		
		
//		BaseUtil baseUtil = null;
//		System.out.println(upOrderInfo);
//		orderService.addUpOrder(upOrderInfo);
//		OrderInfo orderInfo = orderInfoProcessed(upOrderInfo);
//		orderService.addOrder(orderInfo);
//		baseUtil.output(response,JsonUtil.buildFalseJson(0, "添加成功！"));
	}
	
	
	@RequestMapping(value="/showShipOrderList", method=RequestMethod.GET)
	public String showShipOrderList() {
		return "expressManage/shipOrderList";
	}

	@RequestMapping(value="/deleteOrder", method=RequestMethod.POST)
	public void deleteOrder(HttpServletResponse response, OrderInfo orderInfo) {
		BaseUtil baseUtil = null;
		orderService.deleteOrderById(orderInfo.getId());
		baseUtil.output(response, JsonUtil.buildFalseJson(0, "删除成功！"));
		
	}
	
	public OrderInfo orderInfoProcessed(UpOrderInfo upOrderInfo) {
		/*
		 * 1、广东省内:首重8元/KG、续重2元/KG

		 * 2、江苏、浙bai江、海、北京、福建、首重8元/KG、续重4元/KG

		 * 3、津、重庆、安徽、广西、贵州、海南、湖北、湖南、江西、山东、山西、陕西、云南、首重10元/KG、续重5元每/KG

		 * 4、四川、河北、河南、首重12元/KG、续重5元每/KG

		 * 5、甘肃、黑龙江、吉林、辽宁、内蒙古、宁夏、青海、西藏、新疆、首重13元/KG、续重7元/KG

		 * 6、香港、澳门、台湾、首重25元/KG、续重25元/KG
		 * 
		 */
		int area;
		int expressId = Integer.parseInt(upOrderInfo.getExpress());
		String[] area1 = {"广东"};
		String[] area2 = {"江苏", "浙江", "上海", "北京", "福建"};
		String[] area3 = {"天津", "重庆", "安徽", "广西", "贵州",
				"海南", "湖北", "湖南", "江西", "山东", "山西", "陕西", "云南"};
		String[] area4 = {"四川", "河北", "河南"};
		String[] area5 = {"甘肃", "黑龙江", "吉林", "辽宁", "内蒙古",
				"宁夏", "青海", "西藏", "新疆"};
		String[] area6 = {"香港", "澳门", "台湾"};
		//OrderInfo orderInfo = new OrderInfo();
		Price price = priceService.findPriceById(expressId);
		int firstWeight = 0;
		int continuation = 0;
		String originProvice = upOrderInfo.getSenderprovice();
		if(originProvice.endsWith("省")) {
			int index = originProvice.indexOf("省");
			originProvice = originProvice.substring(0, index);
			if(Arrays.asList(area1).contains(originProvice)) {
				area = 1;
				firstWeight = price.getA1f();
				continuation = price.getA1x();
			}else if(Arrays.asList(area2).contains(originProvice)) {
				area = 2;
				firstWeight = price.getA2f();
				continuation = price.getA2x();
			}else if(Arrays.asList(area3).contains(originProvice)) {
				area = 3;
				firstWeight = price.getA3f();
				continuation = price.getA3x();
			}else if(Arrays.asList(area4).contains(originProvice)) {
				area = 4;
				firstWeight = price.getA4f();
				continuation = price.getA4x();
			}else if(Arrays.asList(area5).contains(originProvice)) {
				area = 5;
				firstWeight = price.getA5f();
				continuation = price.getA5x();
			}else if(Arrays.asList(area6).contains(originProvice)) {
				area = 6;
				firstWeight = price.getA6f();
				continuation = price.getA6x();
			}
		}else if(originProvice.endsWith("市")) {
			int index = originProvice.indexOf("市");
			originProvice = originProvice.substring(0, index);
			if(Arrays.asList(area1).contains(originProvice)) {
				area = 1;
				firstWeight = price.getA1f();
				continuation = price.getA1x();
			}else if(Arrays.asList(area2).contains(originProvice)) {
				area = 2;
				firstWeight = price.getA2f();
				continuation = price.getA2x();
			}else if(Arrays.asList(area3).contains(originProvice)) {
				area = 3;
				firstWeight = price.getA3f();
				continuation = price.getA3x();
			}else if(Arrays.asList(area4).contains(originProvice)) {
				area = 4;
				firstWeight = price.getA4f();
				continuation = price.getA4x();
			}else if(Arrays.asList(area5).contains(originProvice)) {
				area = 5;
				firstWeight = price.getA5f();
				continuation = price.getA5x();
			}else if(Arrays.asList(area6).contains(originProvice)) {
				area = 6;
				firstWeight = price.getA6f();
				continuation = price.getA6x();
			}
		}else {
			if(Arrays.asList(area1).contains(originProvice)) {
				area = 1;
				firstWeight = price.getA1f();
				continuation = price.getA1x();
			}else if(Arrays.asList(area2).contains(originProvice)) {
				area = 2;
				firstWeight = price.getA2f();
				continuation = price.getA2x();
			}else if(Arrays.asList(area3).contains(originProvice)) {
				area = 3;
				firstWeight = price.getA3f();
				continuation = price.getA3x();
			}else if(Arrays.asList(area4).contains(originProvice)) {
				area = 4;
				firstWeight = price.getA4f();
				continuation = price.getA4x();
			}else if(Arrays.asList(area5).contains(originProvice)) {
				area = 5;
				firstWeight = price.getA5f();
				continuation = price.getA5x();
			}else if(Arrays.asList(area6).contains(originProvice)) {
				area = 6;
				firstWeight = price.getA6f();
				continuation = price.getA6x();
			}
		}
		int weight = Integer.parseInt(upOrderInfo.getWeight());
		
		int price1;
		price1 = firstWeight + (weight - 1) * continuation;
		
		
		
		
		String sender = upOrderInfo.getSender();
		String senderphone = upOrderInfo.getSenderphone();
		// 整合寄件人地址
		String origin = upOrderInfo.getSenderprovice() + 
				upOrderInfo.getSendercity() + 
				upOrderInfo.getSenderdistrict() + 
				upOrderInfo.getAddress();

		String addressee = upOrderInfo.getAddressee();
		String addresseephone = upOrderInfo.getAddresseephone();
		//Date date = new Date();
		//		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		//		String 
		//		System.out.println("当前时间为: " + ft.format(date));

		// 整合收件人地址
		String end = upOrderInfo.getAddresseeprovice() + 
				upOrderInfo.getAddresseecity() + 
				upOrderInfo.getAddresseedistrict() + 
				upOrderInfo.getAdaddress();
		OrderInfo order = new OrderInfo();
		order.setSender(sender);
		order.setSenderphone(senderphone);
		order.setOrigin(origin);
		order.setAddressee(addressee);
		order.setAddresseephone(addresseephone);
		order.setEnd(end);
		order.setPrice(price1);
		order.setCreatetime(new Date());
		order.setState("待揽件");
		order.setInfo_id(upOrderInfo.getId());
		System.out.println(order);
		return order;

	}

}
