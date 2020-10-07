package com.zhangwei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.dao.BrandDao;
import com.zhangwei.hgshop.dao.CategoryDao;
import com.zhangwei.hgshop.dao.SkuDao;
import com.zhangwei.hgshop.dao.SpuDao;
import com.zhangwei.hgshop.pojo.Brand;
import com.zhangwei.hgshop.pojo.Category;
import com.zhangwei.hgshop.pojo.Sku;
import com.zhangwei.hgshop.pojo.SpecOption;
import com.zhangwei.hgshop.pojo.Spu;
import com.zhangwei.hgshop.pojo.SpuVo;
import com.zhangwei.hgshop.service.GoodsService;
@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImpl implements GoodsService{


	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SpuDao spuDao;
	
	@Autowired
	SkuDao skuDao;
	
	@Autowired
	BrandDao brandDao;
	
	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		System.out.println("+++++++++++++++++++++++++++");
		return brandDao.add(brand);
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.update(brand);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return brandDao.del(id);
	}

	@Override
	public Brand getBrand(Integer id) {
		// TODO Auto-generated method stub
		return brandDao.getBrand(id);
	}

	@Override
	public PageInfo<Brand> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 4);
		
		return new PageInfo<Brand>(brandDao.list(name));
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.add(category);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return categoryDao.delCategory(id);
	}

	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return categoryDao.tree();
	}
	//spu列表
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 6);
		
		return new PageInfo<Spu>(spuDao.list(vo));
	}
	
	@Override
	public int addSpu(Spu spu) {
		// TODO Auto-generated method stub
		int cnt = spuDao.addSpu(spu);
		
		return cnt;
	}

	@Override
	public int updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.updateSpu(spu);
	}

	@Override
	public int deleteSpu(Integer id) {
		// TODO Auto-generated method stub
		return spuDao.deleteSpu(id);
	}
	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuDao.findById(id);
	}
	@Override
	public int deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.deleteSpuBatch(ids);
	}
	//sku
	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		
		return new PageInfo<Sku>(skuDao.list(sku));
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuDao.get(id);
	}

	@Override
	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		int cnt=skuDao.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			
			cnt+=skuDao.addSkuSpec(sku.getId(),specOption);
		}
		return cnt;
	}

	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSku(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandDao.listAll();
	}

	

	

	
	

	
}
