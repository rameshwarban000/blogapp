package com.eduonnetblog.controllers;

import org.springframework.util.StringUtils;

import com.eduonnetblog.entities.BlogOrNews;

/**
 *@author RAMESHWAR
 *@apiNote This is for only update Blog or news entity not with descriptions
 */
public class BlogOrNewRequestObj {

	private Long id;
	private String title;
	private Long category;
	private Long subCategory;
	private int type;// news 1 // blog 2
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public static BlogOrNews getEntity(BlogOrNewRequestObj reqObj) {
		BlogOrNews entity = new BlogOrNews();
		
		if(reqObj.getId() != null && reqObj.getId() != 0) entity.setId(reqObj.getId());
		
		if(StringUtils.hasText(reqObj.getTitle())) entity.setTitle(reqObj.getTitle());
		
		if(reqObj.getCategory() != null && reqObj.getCategory() != 0) entity.setCategory(reqObj.getCategory());
		
		if(reqObj.getSubCategory() != null && reqObj.getSubCategory() != 0) entity.setSubCategory(reqObj.getSubCategory());
		
		entity.setType(reqObj.getType());
		
		return entity;
	}
	
}
