package com.zhangwei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Brand;
import com.zhangwei.hgshop.pojo.Category;
import com.zhangwei.hgshop.pojo.Sku;
import com.zhangwei.hgshop.pojo.Spu;
import com.zhangwei.hgshop.pojo.SpuVo;

public interface GoodsService {
	
	int add(Brand brand);
	
	int update(Brand brand);
	
	int delete(int  id);

	Brand getBrand(Integer id);
	/*
	 * firstChar 首字母
	 * page页码
	 */
	PageInfo<Brand> list(String name,int page);
	
	int	addCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(Integer id);
	
	/*
	 * firstChar 首字母
	 * page页码
	 */
	PageInfo<Category> listCategory(String firstChar,int page);
	List<Category> treeCategory();
	
	//spu管理
	PageInfo<Spu> listSpu(int page,SpuVo vo);
	int	addSpu(Spu spu);
	int updateSpu(Spu spu);
	int deleteSpu(Integer id);
	int deleteSpuBatch(int[] id);
	
	
	
	//spu管理
	PageInfo<Sku> listSku(int page,Sku sku);
	Sku getSku(int id);
	int	addSku(Sku sku);
	int updateSku(Sku sku);
	int deleteSku(Integer id);
	int deleteSkuBatch(int[] id);

	List<Brand> getAllBrands();

	Spu getSpu(int id);

	
	
}
