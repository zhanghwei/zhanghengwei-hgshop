package com.zhangwei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangwei.hgshop.pojo.Category;
import com.zhangwei.hgshop.service.GoodsService;

@Controller
@RequestMapping("cat")
public class CatetgoryController {
	
	@Reference
	GoodsService goodsService;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		
		
		return "cat/list";
	}
	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> tree(HttpServletRequest request) {
		List<Category> list = goodsService.treeCategory();
		for (Category category : list) {
			System.out.println(category);
		}
		request.setAttribute("treeData",list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request,Category category) {
		System.out.println(category);
		int i = goodsService.addCategory(category);
		return i>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("del")
	public String del(HttpServletRequest request,@RequestParam(defaultValue="0")int id) {
		
		return goodsService.deleteCategory(id)>0?"success":"false";
	}
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request,Category cat) {
		System.out.println(cat);
		return goodsService.updateCategory(cat)>0?"success":"false";
	}
	
}
