package com.zhangwei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Brand;
import com.zhangwei.hgshop.pojo.Category;

public interface GoodsService {
	
	int	addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	
	/*
	 * firstChar 首字母
	 * page页码
	 */
	PageInfo<Brand> listBrand(String firstChar,int page);
	
	int	addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	
	/*
	 * firstChar 首字母
	 * page页码
	 */
	PageInfo<Category> listCategory(String firstChar,int page);
	List<Category> treeCategory();
}
