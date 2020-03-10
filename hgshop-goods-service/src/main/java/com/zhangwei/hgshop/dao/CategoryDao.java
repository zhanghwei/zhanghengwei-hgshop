package com.zhangwei.hgshop.dao;

import java.util.List;

import com.zhangwei.hgshop.pojo.Category;

public interface CategoryDao {

	List<Category> tree();

	int add(Category category);

	int delCategory(Integer id);

	int updateCategory(Category category);

}
