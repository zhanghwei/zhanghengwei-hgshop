package com.zhangwei.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sku implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7721716022003692253L;
	private Integer id;
	private String title         ;
	private String sellPoint    ;
	private BigDecimal price         ;
	private int stockCount   ;
	private String barcode       ;
	private String image         ;
	private String status        ;
	private Date createTime   ;
	private Date updateTime   ;
	private BigDecimal costPrice    ;
	private BigDecimal marketPrice  ;
	private int spuId        ;
	private String cartThumbnail;
	private Spu spu;
	//存放属性列表以及属性列表的值
	private List<SpecOption> specs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	public int getSpuId() {
		return spuId;
	}
	public void setSpuId(int spuId) {
		this.spuId = spuId;
	}
	public String getCartThumbnail() {
		return cartThumbnail;
	}
	public void setCartThumbnail(String cartThumbnail) {
		this.cartThumbnail = cartThumbnail;
	}
	public Spu getSpu() {
		return spu;
	}
	public void setSpu(Spu spu) {
		this.spu = spu;
	}
	public List<SpecOption> getSpecs() {
		return specs;
	}
	public void setSpecs(List<SpecOption> specs) {
		this.specs = specs;
	}
	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price + ", stockCount="
				+ stockCount + ", barcode=" + barcode + ", image=" + image + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", costPrice=" + costPrice + ", marketPrice="
				+ marketPrice + ", spuId=" + spuId + ", cartThumbnail=" + cartThumbnail + ", spu=" + spu + ", specs="
				+ specs + "]";
	}
	public Sku(Integer id, String title, String sellPoint, BigDecimal price, int stockCount, String barcode,
			String image, String status, Date createTime, Date updateTime, BigDecimal costPrice, BigDecimal marketPrice,
			int spuId, String cartThumbnail, Spu spu, List<SpecOption> specs) {
		super();
		this.id = id;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.stockCount = stockCount;
		this.barcode = barcode;
		this.image = image;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.costPrice = costPrice;
		this.marketPrice = marketPrice;
		this.spuId = spuId;
		this.cartThumbnail = cartThumbnail;
		this.spu = spu;
		this.specs = specs;
	}
	public Sku() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
