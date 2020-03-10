package com.zhangwei.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangwei.hgshop.pojo.Sku;
import com.zhangwei.hgshop.pojo.SpecOption;

public interface SkuDao {
	List<Sku> list(Sku sku);
	
	Sku get(int id);

	int addSku(Sku sku);
	
	int addSkuSpec(@Param("skuId")int skuId,@Param("so")SpecOption so);
}
