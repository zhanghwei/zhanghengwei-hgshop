package com.zhangwei.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhangwei.hgshop.service.UserService;

@Controller
public class UserController {

	@Reference
	UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin() {
	
		return "login2";
	}
	@RequestMapping("login")
	public String login(String name,String password) {
		System.out.println(name+"-----"+password);
		if(userService.login(name, password)) {
			return "redirect:index";
		}
		else {
			return "login2";
		}
		
	}
}
