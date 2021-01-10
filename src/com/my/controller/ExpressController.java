package com.my.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.service.ExpressService;
import com.my.utils.BaseUtil;
import com.my.utils.JsonUtil;
import com.my.vo.Account;
import com.my.vo.Express;



@RequestMapping(value="/express")
@Controller
public class ExpressController {

	@Autowired
	private ExpressService expressService;
	
	
	@RequestMapping(value="/showExpressList")
	public String showExpressList() {

		return "expressManage/expressList";
	}

	// 获取快递列表
	@RequestMapping("/getExpressList")
	public void getUserList(HttpServletRequest request,
			HttpServletResponse response,
			Express express,Integer page,
			Integer limit){
		System.out.println("Hello Express");
		Account account = (Account) request.getSession().getAttribute("account");
		System.out.println("phone => " + account.getPhone());
		String phone = account.getPhone();
		if(page == null){
			page = 1;
		}
		if(limit == null){
			limit = 10;
		}
		BaseUtil baseUtil = new BaseUtil();
		Integer totalCount = expressService.showExpressListCount(phone);
		List<Express> list = expressService.showExpressList(phone);
		//List<User> list = userService.getUserList(user,(page-1) * limit, limit);
		BaseUtil.output(response, JsonUtil.buildJsonByTotalCount(list, totalCount));

	}


}
