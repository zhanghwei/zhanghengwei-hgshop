package com.zhangwei.hgshop.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author MACHENIKE
 *分类
 */
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9018756890495326995L;
	private Integer id;
	private Integer parentId;//上一级别分类 的id
	@JsonProperty("text")
	private String name;//分类的名称
	private String path;//从根分类到当前分类的路径
	@JsonProperty("nodes")
	private List<Category> children;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", path=" + path + "]";
	}
	
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Category(Integer id, Integer parentId, String name, String path) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.path = path;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
