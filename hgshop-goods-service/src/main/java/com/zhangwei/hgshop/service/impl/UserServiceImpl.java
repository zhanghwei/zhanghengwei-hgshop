package com.zhangwei.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.zhangwei.hgshop.service.UserService;
@Service(interfaceClass=UserService.class)
public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		return "admin".equals(userName)&&"123456".equals(passWord);
	}

}
