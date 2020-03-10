package com.zhangwei.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Spec;
import com.zhangwei.hgshop.service.SpecService;

@Controller
@RequestMapping("/spec/")
public class SpecController {
	@Reference
	SpecService specService;
	
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,HttpServletRequest request,@RequestParam(defaultValue="")String name) {
		PageInfo<Spec> list = specService.list(name, pageNum);
		request.setAttribute("pageInfo", list);
		request.setAttribute("queryName", name);
		return "spec/list";
	}
	@ResponseBody
	@RequestMapping("add")
	public Object add(HttpServletRequest request,Spec spec) {
		System.out.println("spec"+spec);
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		
		System.out.println("spec处理后："+spec);
		int add=specService.add(spec);
		System.out.println(add+"++++++");
		return add>0;
	}
	@ResponseBody
	@RequestMapping("delSpec")
	public String delSpec(HttpServletRequest request,int id) {
		int delNum = specService.delete(id);
		return delNum>0?"success":"false";
	}
	@ResponseBody
	@RequestMapping("delSpecBatch")
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]")int[] ids) {
		for (int i : ids) {
			System.out.println("i is"+i);
		}
		
		int delNum = specService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}
	
}
