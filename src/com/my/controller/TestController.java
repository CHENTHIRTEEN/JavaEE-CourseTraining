package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.vo.Account;
@SessionAttributes("account")
@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value="denglu", method=RequestMethod.GET)
	public  String zhuce() {
		return "zhuce";
	}
	
	@RequestMapping(value="denglu", method=RequestMethod.POST)
	public  String zhuce1(@RequestParam("loginname")String loginname,@RequestParam("password")String password, Model model) {
		Account account = new Account();
		System.out.println("loginname => " + loginname);
		account.setLoginname(loginname);
		account.setPassword(password);
		model.addAttribute("account", account);
		return "testLogin";
	}

	@RequestMapping(value="pageTest", method=RequestMethod.GET)
	public String toIndexPage() {
		
		return "index";
	}
}
