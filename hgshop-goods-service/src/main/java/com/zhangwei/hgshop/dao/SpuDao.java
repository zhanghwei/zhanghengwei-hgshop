package com.zhangwei.hgshop.dao;

import java.util.List;

import com.zhangwei.hgshop.pojo.Spu;
import com.zhangwei.hgshop.pojo.SpuVo;

public interface SpuDao {

	List<Spu> list(SpuVo vo);

	int addSpu(Spu spu);

	int updateSpu(Spu spu);

	int deleteSpu(Integer id);

	int deleteSpuBatch(int[] ids);

	Spu findById(int id);

}
