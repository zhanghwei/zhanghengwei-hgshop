package com.zhangwei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Spec;

public interface SpecService {

	PageInfo<Spec> list(String name,int page);
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int  id);
	
	int deleteBatch(int[]  id);
	
	Spec findById(int id);

	List<Spec> listAll();
}
