package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/homepage")
public class HomepageController {

	@RequestMapping(value="/toHomepage", method=RequestMethod.GET)
	public String toIndexPage() {

		return "index";
	}

	// 显示用户的快递
	@RequestMapping(value="/toExpressList")
	public String toExpressList() {

		return "express/expressList";
	}
}
