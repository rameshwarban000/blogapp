package com.eduonnetblog.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;
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
	
	
	@RequestMapping(value ="/blogDetails")
	public String blogDetails() {
		
		return "blogdetails";
	}
	
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
						newsListObject = putEntityWiseDescriptionInList(newsList, descriptions);
						blogListObject = putEntityWiseDescriptionInList(blogList, descriptions);
					}
				}
				request.setAttribute("newsList", newsListObject);
				request.setAttribute("blogList", blogListObject);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryWiseBlogs";
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
				entityObject.put("category", entity.getCategory());
				entityObject.put("subCategory", entity.getSubCategory());
				entityObject.put("type", entity.getType());
				
				JSONArray descriptionArray = new JSONArray();
				for(Description description : descriptions) {
					if(entity.getId() == description.getBlogId()) {
						JSONObject descJsonObject = new JSONObject();
						descJsonObject.put("id", description.getId());
						descJsonObject.put("title", description.getTitle());
						descJsonObject.put("blogId", description.getBlogId());
						descJsonObject.put("description", description.getDescription());
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
