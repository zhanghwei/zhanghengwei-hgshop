package com.zhangwei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.dao.SpecDao;
import com.zhangwei.hgshop.pojo.Spec;
import com.zhangwei.hgshop.pojo.SpecOption;
import com.zhangwei.hgshop.service.SpecService;
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService{

	@Autowired
	SpecDao specDao;
	
	
	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		
		return new PageInfo<Spec>(specDao.list(name));
	}

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		//添加主表
		specDao.addSpec(spec);
		//这里才能获取到主键id
		//添加子表
		int n =1;
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			specOption.setSpecId(spec.getId());
			specDao.addOptions(specOption);
			n++;
		}
		// 返回的是影响数据的条数
		return n;
	}

	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		return specDao.updateSpec(spec);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		specDao.deleteSpecOptions(id);
		specDao.deleteSpec(id);
		return 1;
	}

	@Override
	public int deleteBatch(int[] id) {
		// TODO Auto-generated method stub
		specDao.deleteSpecOptionsBatch(id);
		specDao.deleteSpecBatch(id);
		
		return 1;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.get(id);
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

}
