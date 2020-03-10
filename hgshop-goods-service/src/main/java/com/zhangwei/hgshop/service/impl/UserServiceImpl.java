package com.zhangwei.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhangwei.hgshop.config.AdminProperties;
import com.zhangwei.hgshop.service.UserService;
@Service(interfaceClass=UserService.class)
public class UserServiceImpl implements UserService{

	
	@Autowired
	AdminProperties adminPro;
	
	@Override
	public boolean login(String userName, String passWord) {
		// TODO Auto-generated method stub
		String adminName = adminPro.getAdminName();
		String pwd = adminPro.getPassword();
		
		return adminName.equals(userName)&&pwd.equals(passWord);
	}

}
