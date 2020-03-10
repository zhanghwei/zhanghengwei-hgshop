package com.zhangwei.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhangwei.hgshop.pojo.Brand;

public interface BrandDao {

	List<Brand> list(String name);

	int add(Brand brand);

	int del(int id);

	Brand getBrand(Integer id);

	int update(Brand brand);
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> listAll();

}
