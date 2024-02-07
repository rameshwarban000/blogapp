package com.eduonnetblog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	@GeneratedValue()
	private long id;
	private String comment;
	private long userId;
	private long blogOrNewsId;
	private long date;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBlogOrNewsId() {
		return blogOrNewsId;
	}
	public void setBlogOrNewsId(long blogOrNewsId) {
		this.blogOrNewsId = blogOrNewsId;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
}
