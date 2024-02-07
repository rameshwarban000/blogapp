package com.eduonnetblog.controllers;

import java.util.List;

import org.springframework.util.StringUtils;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;

public class BlogOrNewsReqObj {

	
	private String title;
	private Long category;
	private Long subCategory;
	private int type;// news 1 // blog 2
	private List<Description> descriptions;

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

	public List<Description> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
	public static BlogOrNews getEntity(BlogOrNewsReqObj reqObj) {
		if(reqObj != null) {
			BlogOrNews entity = new BlogOrNews();
			if(reqObj.getCategory() != null ) entity.setCategory(reqObj.getCategory());
			if(reqObj.getSubCategory() != null) entity.setSubCategory(reqObj.getSubCategory());
			if(StringUtils.hasText(reqObj.getTitle())) entity.setTitle(reqObj.getTitle());
			if(reqObj.getType() != 0) entity.setType(reqObj.getType());
			return entity;
		}
		return null;
	}
	
}
