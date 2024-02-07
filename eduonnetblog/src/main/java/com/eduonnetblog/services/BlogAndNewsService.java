package com.eduonnetblog.services;

import java.util.List;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.BlogOrNewsResObj;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;

public interface BlogAndNewsService {

	public BlogOrNewsResObj saveBlogOrNews(BlogOrNews blogOrNews);
	
	public void saveImage(Image image);

	public List<BlogOrNews> getNewsByCategory(Long categoryId);
	
	public List<BlogOrNews> getBlogsByCategory(Long categoryId);

	public List<Long> saveDescriptions(List<Description> descriptions);

	public List<Description> getDescriptions(List<Long> descriptonIds);
}
