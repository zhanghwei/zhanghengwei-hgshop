package com.zhangwei.hgshop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhangwei.hgshop.pojo.Brand;
import com.zhangwei.hgshop.pojo.Sku;
import com.zhangwei.hgshop.pojo.Spec;
import com.zhangwei.hgshop.pojo.Spu;
import com.zhangwei.hgshop.pojo.SpuVo;
import com.zhangwei.hgshop.service.GoodsService;
import com.zhangwei.hgshop.service.SpecService;

@Controller
@RequestMapping("/goods/")
public class GoodsController {

	@Reference
	GoodsService goodsService;
	
	@Reference
	SpecService specService;
	
	@RequestMapping("goodsAdd")
	@ResponseBody
	public String add(HttpServletRequest request,Spu spu,@RequestParam(value="file") MultipartFile file ) throws IllegalStateException, IOException {
		System.out.println(spu+":spu");
		/**
		 * 返回的上传文件存放的物理地址
		 */
		String filePath=processFile(file);
		// 可以根据 这个地址下载
		spu.setSmallPic(filePath);
		
		int result = goodsService.addSpu(spu);
		
		return result>0?"success":"failed";
		
	}
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {

		// 原来的文件名称
		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "d:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);//文件另存到这个目录下边
		return destFileName.substring(7);	
	}
	@RequestMapping("skuDetail")
	public String skuDetail(HttpServletRequest request,int id) {
		Sku sku = goodsService.getSku(id);
		request.setAttribute("sku",sku);
		return "sku/detail";
	}
	
	
	@RequestMapping("toAdd")
	public String toAddBrand(HttpServletRequest request) {
		List<Brand> list=goodsService.getAllBrands();
		for (Brand brand : list) {
			System.out.println(brand);
		}
		request.setAttribute("list",list);
		
		return "goods/add";
	}
	/**
	 * 跳转到sku添加页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("toaddSku")
	public String toaddSku(HttpServletRequest request,int id) {
		//获取要添加的商品
		Spu spu=goodsService.getSpu(id);
		request.setAttribute("spu", spu);
		List<Spec> list=specService.listAll();
		System.out.println("list:"+list);
		request.setAttribute("specs",list);
		return "sku/add";
	}
	
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,SpuVo vo) {
		PageInfo<Spu> listSpu = goodsService.listSpu(pageNum, vo);
		request.setAttribute("pageInfo", listSpu);
		
		return "goods/list";
	}
	@RequestMapping("skuList")
	public String skuList(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,Sku sku) {
		PageInfo<Sku> listSku = goodsService.listSku(pageNum, sku);
		List<Sku> list = listSku.getList();
		for (Sku sku2 : list) {
			System.out.println(sku2+"++++");
		}
		request.setAttribute("pageInfo",listSku);
		request.setAttribute("list",list);
		
		return "sku/list";
	}

	@RequestMapping("brandList")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,Model m,String name) {
		System.out.println("品牌列表"+name);
		PageInfo<Brand> list = goodsService.list(name, pageNum);
		List<Brand> brandList = list.getList();
		for (Brand brand : brandList) {
			System.out.println(brand);
		}
		m.addAttribute("pageInfo", list);
		m.addAttribute("list", brandList);
		m.addAttribute("queryName", name);
		return "brand/list";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Object add(Brand brand) {
		int add = goodsService.add(brand);
		
		return add>0;
	}
	@ResponseBody
	@RequestMapping("update")
	public Object update(Brand brand) {
		System.out.println(brand);
		int add = goodsService.update(brand);
		
		return add>0;
	}
	
	@ResponseBody
	@RequestMapping("del")
	public Object del(int id) {
		int del = goodsService.delete(id);
		
		return del>0;
	}
	
	@ResponseBody
	@RequestMapping("getBrand")
	public Object getBrand(Integer id,Model m) {
		System.out.println(id+":id");
		Brand brand= goodsService.getBrand(id);	
		System.out.println(brand);
		return brand;
	}
}
