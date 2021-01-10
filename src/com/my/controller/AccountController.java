package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.my.service.AccountService;
import com.my.vo.Account;


@Controller
@SessionAttributes("account")
@RequestMapping("/account")
public class AccountController {



	@Autowired
	private AccountService accountService;

	
	@RequestMapping(value="/cusLogout")
	public String cusLogout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "customerLogin";
	}
	
	// 跳转到用户登录页面
	@RequestMapping(value="cusLogin", method=RequestMethod.GET)
	public  String toLogin() {
		return "customerLogin";
	}
	

//	@RequestMapping(value="/cusLogin")
//	public void doLogin(HttpServletRequest request,HttpServletResponse response,Account account){
//		//User pcUser = (User) request.getSession().getAttribute("pcUser");
//		Account account = (Account) request.getSession().getAttribute("")
//		if(pcUser == null){
//			if(user.getUserId() == null){
//	        	output(response,JsonUtil.buildFalseJson(1,"账号不能为空"));
//	        }
//			if(user.getPassword().equals("") || user.getPassword() == null){
//      		  	output(response,JsonUtil.buildFalseJson(1,"密码不能为空"));
//      	  	}
//			User userInfo = userService.getUserById(user.getUserId());
//  		  	if(userInfo == null){
//  		  		output(response,JsonUtil.buildFalseJson(1,"账号不正确或系统不存在该用户"));
//  		  	}		  
//  		  	if(!userInfo.getPassword().equals(MD5Util.MD5Encode(user.getPassword(),"utf-8"))){
//  		  		output(response,JsonUtil.buildFalseJson(1,"您输入的密码不正确,请重试")); 
//  		  	}		  
//  		  	//判断账号是否被禁用
//  		  	if(userInfo.getIsEffect() != 1){
//  		  		output(response,JsonUtil.buildFalseJson(1,"对不起您的账号已被禁用"));
//  		  	}else{
//  		  		//执行登陆后台的逻辑
//  		  		request.getSession().setAttribute("pcUser",userInfo);
//  		  		output(response,JsonUtil.buildFalseJson(0,"登录成功"));
//  		  	}
//		}else{
//			output(response,JsonUtil.buildFalseJson(0,"您已登录，无需重复登录"));
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	//用户登录校验
	@RequestMapping(value="cusLogin", method=RequestMethod.POST)
	public String login(@RequestParam("loginname")String loginname,
			@RequestParam("password")String password,
			Model model) {
		Account account = accountService.loginByName(loginname);
		System.out.println("loginname => " + loginname);
		System.out.println("password => " + password);
		//		account.setLoginname(loginname);
		//		account.setPassword(password);
		if(account.getPassword().equals(password)) {
			account.setLoginname(loginname);
			account.setPassword(password);
			model.addAttribute("account", account);
			//model.addAttribute("account", account);
			return "redirect:/homepage/toHomepage";
			
			//return "testLogin";
		}else {
			return "redirect:/error01";
		}
	}
	

	// 跳转到注册页面
	@RequestMapping(value="toRegister")
	public String toRegister() {
		return "register";
	}
	

	// 注册校验
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(@RequestParam("name")String name,
			@RequestParam("loginname")String loginname, 
			@RequestParam("password")String password,
			@RequestParam("passwordConfirm")String passwordConfirm,
			@RequestParam("phone")String phone) {

		Account account = new Account();
		String flag = accountService.isAccountExistence(loginname);
		System.out.println(flag);
		if(flag.equals("Y")) {
			// 判断要注册的账户是否已经存在
			return "error02";
		}else { 
			if(password.equals(passwordConfirm)) {
				// 两次输入的密码相同则可以开始注册, 否则跳转到错误页面
				account.setName(name);
				account.setLoginname(loginname);
				account.setPassword(passwordConfirm);
				account.setPhone(phone);
				accountService.customerRegister(account);
				return "registerSuccess";
			}else {
				return "error03";
			}
			
		}

	}
	
	@RequestMapping(value="toChangePassword", method=RequestMethod.GET)
	public String toChangePassword() {
		return "changePassword";
	}
	
	
	// 修改密码
	@RequestMapping(value="changePassword", method=RequestMethod.POST)
	public String changePassword(@RequestParam("loginname")String loginname, @RequestParam("newpassword")String newpassword,@RequestParam("newpasswordconfirm")String newpasswordconfirm, Model model) {
		Account account = new Account();
//		System.out.println("loginname => " + loginname);
//		System.out.println("password => " + password);
		//		account.setLoginname(loginname);
		//		account.setPassword(password);
		if(newpassword.equals(newpasswordconfirm)) {
			int id = accountService.loginByName(loginname).getId();
			account.setId(id);
			account.setPassword(newpassword);
			System.out.println("password => " + newpassword);
			accountService.changeCusPassword(account);
			return "customerLogin";
		}else {
			return "error04";
		}
	}
	
	@RequestMapping("/toMain")
	public ModelAndView goMain(ModelAndView mv, HttpServletRequest request) {
		mv.setViewName("main");
		return mv;
	}
}
