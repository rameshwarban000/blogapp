package com.eduonnetblog.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;
import com.eduonnetblog.services.BlogAndNewsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PagePathControllers {
	
	
	@Autowired
	BlogAndNewsService blogAndNewsService;

	
	@RequestMapping(value ="/aboutme")
	public String aboutPage() {
		
		return "about";
	}
	
	@RequestMapping(value ="/createblog")
	public String createBlogPage() {
		
		return "createblogpage";
	}
	
	
	@RequestMapping(value ="/blogDetails/{blogId}")
	public String blogDetails(HttpServletRequest request, @PathVariable  String blogId) {
		// get id wise blog 
		if(StringUtils.hasText(blogId) && !blogId.contains("...")) {
			try {
				System.out.println("called Blog detials controller");
				
				BlogOrNews entity = blogAndNewsService.getBlogOrNewsById(blogId);
				if (entity != null) {
					JSONObject entityJsonObject= JSONObject.fromObject(entity);
				
					request.setAttribute("entity", entityJsonObject);

					List<Description> descriptions = blogAndNewsService
							.getDescriptionsByBlogId(Long.parseLong(blogId));

					if (descriptions != null && !descriptions.isEmpty()) {
						JSONArray descriptionArray = JSONArray.fromObject(descriptions);
						request.setAttribute("descriptions", descriptionArray);
						List<Long> imageIds = new ArrayList<Long>();

						for (Description desc : descriptions) {
							imageIds.add(desc.getImageId());
						}
						List<Image> images = blogAndNewsService.getImagesByIds(imageIds);
						JSONArray imageArray = JSONArray.fromObject(images);
						request.setAttribute("images", imageArray);
					}
					
					// getcategory wise 5 random blog 
					List<BlogOrNews> recomondedBlogs = blogAndNewsService.getBlogsByCategory(entity.getCategory());
					if(recomondedBlogs != null && recomondedBlogs.size() > 0 ) {
						
						JSONArray recBlogArray = convertBlogListIntoJsonArray(recomondedBlogs);
						request.setAttribute("recBlogList", recBlogArray);
						
						List<Long> recomandedBlogIds = new ArrayList<Long>();
						for(BlogOrNews blog : recomondedBlogs) {
							recomandedBlogIds.add(blog.getId());
						}
						
						List<Description> recomondedBlogsDescriptions = blogAndNewsService.getDescriptions(recomandedBlogIds);
						
						if(recomondedBlogsDescriptions != null && recomondedBlogsDescriptions.size() > 0 ) {
							JSONArray recDescArray = convertDescriptionListIntoJsonArray(recomondedBlogsDescriptions);
							request.setAttribute("recDescList", recDescArray);
							List<Long> imagesId = new ArrayList<Long>();
							for(Description desc : recomondedBlogsDescriptions) {
								imagesId.add(desc.getImageId());
							}
							
							List<Image> recImgList = blogAndNewsService.getImagesByIds(imagesId);
							if(recImgList != null && recImgList.size() > 0 ) {
								JSONArray recImgArray = convertImageListIntoJsonArray(recImgList);
								
								request.setAttribute("recImgList", recImgArray);
							}
						}
					}
				}else {
					throw new IllegalArgumentException("Entity not found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "blogdetails";
	}
	

	private JSONArray convertImageListIntoJsonArray(List<Image> recImgList) {
		JSONArray jsonArray = new JSONArray();
		if(recImgList != null && recImgList.size() >0 ) {
			for(Image img :  recImgList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", img.getId());
				jsonObject.put("date", img.getDate());
				jsonObject.put("data", img.getData());
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}
	

	private JSONArray convertDescriptionListIntoJsonArray(List<Description> recomondedBlogsDescriptions) {
		JSONArray jsonArray = new JSONArray();
		if(recomondedBlogsDescriptions != null && recomondedBlogsDescriptions.size() >0 ) {
			for(Description desc :  recomondedBlogsDescriptions) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", desc.getId());
				jsonObject.put("title", desc.getTitle());
				jsonObject.put("date", desc.getDate());
				jsonObject.put("imageId", desc.getImageId());
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	private JSONArray convertBlogListIntoJsonArray(List<BlogOrNews> recomondedBlogs) {
		JSONArray jsonArray = new JSONArray();
		if(recomondedBlogs != null && recomondedBlogs.size() >0 ) {
			for(BlogOrNews blog :  recomondedBlogs) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", blog.getId());
				jsonObject.put("title", blog.getTitle());
				jsonObject.put("date", blog.getDate());
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
	}

	/*
	 * @RequestMapping(value ="/homePage/") public String getHomePage() {
	 * 
	 * return "homePage"; }
	 */
	
	@RequestMapping(value = "/categoryWiseBlogs/{categoryId}", method = RequestMethod.GET)
	public String getCategoryWiseIngo(HttpServletRequest request, @PathVariable  String categoryId) {
		// get News
		try {
			if(categoryId != null) {
				Long category = Long.parseLong(categoryId);
				List<BlogOrNews> newsList = blogAndNewsService.getNewsByCategory(category);
				// get Blogs
				List<BlogOrNews> blogList = blogAndNewsService.getBlogsByCategory(category);
				
				List<Long> entityIds = new ArrayList<Long>();
				if(newsList != null && !newsList.isEmpty()) {
					for(BlogOrNews news : newsList) {
						entityIds.add(news.getId());
					}
				}
				
				if(blogList != null && !blogList.isEmpty()) {
					for(BlogOrNews blog : blogList) {
						entityIds.add(blog.getId());
					}
				}
				JSONArray newsListObject = new JSONArray();
				JSONArray blogListObject = new JSONArray();
				if(entityIds != null && !entityIds.isEmpty()) {
					List<Description> descriptions = blogAndNewsService.getDescriptions(entityIds);
					if(descriptions != null && !descriptions.isEmpty()) {
						JSONObject descriptionWiseImage = blogAndNewsService.getImageByIdList(descriptions);
						newsListObject = putEntityWiseDescriptionInList(newsList, descriptions);
						blogListObject = putEntityWiseDescriptionInList(blogList, descriptions);
						request.setAttribute("descWiseImages", descriptionWiseImage);
					}
				}
				request.setAttribute("newsList", newsListObject);
				request.setAttribute("blogList", blogListObject);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryWiseBlog";
	}

	/**
	 * @author RAMESHWAR
	 * @apiNote fill entity wise description list
	 * @param blogOrNewsList
	 * @param descriptions
	 * @return
	 */
	private JSONArray putEntityWiseDescriptionInList(List<BlogOrNews> blogOrNewsList, List<Description> descriptions) {
		if(descriptions != null && !descriptions.isEmpty() && blogOrNewsList != null && !blogOrNewsList.isEmpty()) {
		// create categoryId wise description Map.
			JSONArray entityJsonArray = new JSONArray();
			
			for(BlogOrNews entity : blogOrNewsList) {
				JSONObject entityObject = new JSONObject();
				entityObject.put("id", entity.getId());
				entityObject.put("title", entity.getTitle());
				entityObject.put("date", entity.getDate());
				
				JSONArray descriptionArray = new JSONArray();
				for(Description description : descriptions) {
					if(entity.getId() == description.getBlogId()) {
						JSONObject descJsonObject = new JSONObject();
						descJsonObject.put("id", description.getId());
						descJsonObject.put("title", description.getTitle());
						descJsonObject.put("blogId", description.getBlogId());
						descriptionArray.add(descJsonObject);
					}
				}
				entityObject.put("descriptions", descriptionArray);
				entityJsonArray.add(entityObject);
			}
			return entityJsonArray;
		}
		return null;
	}

}
