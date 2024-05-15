package com.eduonnetblog.services;

import java.util.List;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.BlogOrNewsResObj;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;

import net.sf.json.JSONObject;

public interface BlogAndNewsService {

	public BlogOrNewsResObj saveBlogOrNews(BlogOrNews blogOrNews);
	
	public void saveImage(Image image);

	public List<BlogOrNews> getNewsByCategory(Long categoryId);
	
	public List<BlogOrNews> getBlogsByCategory(Long categoryId);

	public List<Long> saveDescriptions(List<Description> descriptions);

	public List<Description> getDescriptions(List<Long> descriptonIds);

	public JSONObject getImageByIdList(List<Description> descriptions);

	public void deleteBlogORNewsDescriptions(String entityId);

	public void deleteEntityById(String entityId);

	public void deleteDescriptionAndImageById(String entityId);

	public void deleteDescriptionImage(String imgId);

	public BlogOrNews getBlogOrNewsById(String entityId);

	public List<Description> getDescriptionsByBlogOrNewsIds(List<Long> asList);

	public List<Image> getImagesByIds(List<Long> imageIds);

	public List<Description> getDescriptionsByBlogId(long parseLong);

	public List<BlogOrNews> getAllBlockAndNews(Long pageNumber, Long pageSize);
}
