package com.eduonnetblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogOrNews {

	@Id
	@GeneratedValue()
	private Long id;
	private String title;
	private Long category;
	private Long subCategory;
	private int type;// news 1 // blog 2
	
	private Long date;
	
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

	public long getCategory() {
		return category;
	}
	public void setCategory(long category) {
		this.category = category;
	}
	
	public Long getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public static BlogOrNewsResObj getResponce(BlogOrNews blogOrNews) {
		BlogOrNewsResObj blogOrNewsResObj = new BlogOrNewsResObj();
		blogOrNewsResObj.setCategory(blogOrNews.getCategory());
		blogOrNewsResObj.setId(blogOrNews.getId());
		blogOrNewsResObj.setSubCategory(blogOrNews.getSubCategory());
		blogOrNewsResObj.setTitle(blogOrNews.getTitle());
		blogOrNewsResObj.setType(blogOrNews.getType());
		return blogOrNewsResObj;
	}
	
}
