package com.eduonnetblog.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;

@Service
public class BlogOrNewsDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public void saveBlogOrNews(BlogOrNews blogOrNews) {
		 try {
	            // Save the main BlogOrNews entity
	            hibernateTemplate.saveOrUpdate(blogOrNews);
	        } catch (Exception e) {
	            throw new IllegalArgumentException(e.getMessage());
	        }
	}

	public void saveImage(Image image) {
		try {
			hibernateTemplate.saveOrUpdate(image);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	/**
	 * @author RAMESHWAR
	 * @param categoryId
	 * @param i 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<BlogOrNews> getNewsOrBlogsByCategories(Long categoryId, int type) {

		String hql = "FROM BlogOrNews WHERE category = :category AND type = :type";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("category", categoryId);
		parameters.put("type", type);
		return (List<BlogOrNews>) hibernateTemplate.findByNamedParam(hql, parameters.keySet().toArray(new String[0]),
				parameters.values().toArray());

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Description> getDescriptionByBlogOrNewsIds(List<Long> newsIds) {
	    if (newsIds == null || newsIds.isEmpty()) {
	        return Collections.emptyList();
	    }
	    String hql = "SELECT DISTINCT d FROM BlogOrNews b JOIN b.descriptions d WHERE b.id IN (:blogOrNewsIds)";
	    return (List<Description>) hibernateTemplate.findByNamedParam(hql, "blogOrNewsIds", newsIds.toArray());
	}

	public List<Long> saveDescrptions(List<Description> descriptions) {
		  try {
		        List<Long> descriptionIds = new ArrayList<>();
		        for (Description description : descriptions) {
		            hibernateTemplate.saveOrUpdate(description);
		            descriptionIds.add(description.getId());
		        }
		        return descriptionIds;
		    } catch (Exception e) {
		        throw new IllegalArgumentException(e.getMessage());
		    }
	}

	public List<Description> getDescriptionsByIds(List<Long> entityIds) {
		String hql = "FROM Description d WHERE d.blogId IN (:entityIds)";	
		return (List<Description>) hibernateTemplate.findByNamedParam(hql, "entityIds", entityIds);
	}

}
