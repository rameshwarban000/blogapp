package com.eduonnetblog.entities;

import java.util.List;

public class BlogOrNewsResObj {
	
	private long id;
	private String title;
	private Long category;
	private Long subCategory;
	private int type;// news 1 // blog 2
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Long getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
