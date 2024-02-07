package com.eduonnetblog.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonnetblog.daos.BlogOrNewsDao;
import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.BlogOrNewsResObj;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;

import net.sf.json.JSONObject;

@Service
public class BlogAndNewsServiceImpl implements BlogAndNewsService{
	
	@Autowired
	BlogOrNewsDao blogOrNewsDao;


	@Override
	@Transactional
	public BlogOrNewsResObj saveBlogOrNews(BlogOrNews blogOrNews) {
		blogOrNewsDao.saveBlogOrNews(blogOrNews);
		return BlogOrNews.getResponce(blogOrNews);
	}
	
	@Override
	@Transactional
    public void saveImage(Image image){
		blogOrNewsDao.saveImage(image);
    }

	@Override
	@Transactional
	public List<BlogOrNews> getNewsByCategory(Long categoryId) {
		return blogOrNewsDao.getNewsOrBlogsByCategories(categoryId, 2);
	}

	@Override
	@Transactional
	public List<BlogOrNews> getBlogsByCategory(Long categoryId) {
		return blogOrNewsDao.getNewsOrBlogsByCategories(categoryId, 1);
	}

	@Override
	@Transactional
	public List<Long> saveDescriptions(List<Description> descriptions) {
		
		if(descriptions != null && !descriptions.isEmpty()) {
			return blogOrNewsDao.saveDescrptions(descriptions);
		}
		
		return null;
	}

	@Override
	@Transactional
	public List<Description> getDescriptions(List<Long> descriptonIds) {
		if(descriptonIds != null && !descriptonIds.isEmpty()) {
			return blogOrNewsDao.getDescriptionsByIds(descriptonIds);
		}
		return null;
	}

	@Override
	@Transactional
	public JSONObject getImageByIdList(List<Description> descriptions) {
		if(descriptions != null && !descriptions.isEmpty()) {
			List<Long>  imagesIds = new ArrayList<Long>();
			for(Description description : descriptions) {
				if(description.getImageId() != null) {
					imagesIds.add(description.getImageId());
				}
			}
			List<Image> images = blogOrNewsDao.getImagesByIds(imagesIds);
			
			if(images != null && !images.isEmpty()) {
				JSONObject descriptionWiseImage = new JSONObject();
				for(Description desc : descriptions) {
					
					for(Image img : images) {
						if(img.getId() == desc.getImageId()) {
							descriptionWiseImage.put(desc.getId() , img);
							images.remove(img);
							break;
						}
					}
				}
				return descriptionWiseImage;
			}
		}
		return null;
	}

	

	

}
