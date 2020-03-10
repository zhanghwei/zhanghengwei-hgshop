package com.zhangwei.hgshop.dao;

import java.util.List;

import com.zhangwei.hgshop.pojo.Spec;
import com.zhangwei.hgshop.pojo.SpecOption;

public interface SpecDao {

	List<Spec> list(String name);

	int addSpec(Spec spec);

	int addOptions(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOptions(int id);

	int deleteSpec(int id);

	Spec get(int id);

	int deleteSpecOptionsBatch(int[] id);

	int deleteSpecBatch(int[] id);

	List<Spec> listAll();



}
