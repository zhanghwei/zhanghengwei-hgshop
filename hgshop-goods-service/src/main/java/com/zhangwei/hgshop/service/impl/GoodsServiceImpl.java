package com.zhangwei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Brand;
import com.zhangwei.hgshop.pojo.Category;
import com.zhangwei.hgshop.service.GoodsService;
@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl implements GoodsService{

	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
