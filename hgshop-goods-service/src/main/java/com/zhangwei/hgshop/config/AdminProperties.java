package com.zhangwei.hgshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/*
 * 配置类读取属性文件
 */
@Configuration
@PropertySource("classpath:hgshop-admin-properties")
public class AdminProperties {

	@Value("${admin.name}")
	String adminName;
	@Value("${admin.pwd}")
	String password;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
