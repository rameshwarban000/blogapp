package com.eduonnetblog.daos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;
import com.mysql.cj.Query;

@Service
public class BlogOrNewsDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public void saveBlogOrNews(BlogOrNews blogOrNews) {
		 try {
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
	 * @apiNote getting only id and title 
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<BlogOrNews> getNewsOrBlogsByCategories(Long categoryId, int type) {

		String hql = "SELECT id, title, date FROM BlogOrNews WHERE category = :category AND type = :type";
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("category", categoryId);
	    parameters.put("type", type);
	   List<Object[]> resultsArray =  (List<Object[]>) hibernateTemplate.findByNamedParam(hql, parameters.keySet().toArray(new String[0]),
	            parameters.values().toArray());
	   
	   if(resultsArray != null && !resultsArray.isEmpty()) {
		   List<BlogOrNews> blogOrNewsList = new ArrayList<BlogOrNews>();
		   for(Object[] restlArray : resultsArray) {
			   BlogOrNews blogOrNews = new  BlogOrNews();
			   blogOrNews.setId((long) restlArray[0]);
			   blogOrNews.setTitle((String) restlArray[1]);
			   blogOrNews.setDate((long) restlArray[2]);
			   blogOrNewsList.add(blogOrNews);
		   }
		  return blogOrNewsList;
	   }
	   return null;
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
		String hql = "SELECT d.id, d.title, d.imageId, d.blogId, d.date FROM Description d WHERE d.blogId IN (:entityIds)";
		List<Object[]> resultsArray = (List<Object[]>) hibernateTemplate.findByNamedParam(hql, "entityIds", entityIds);
		if (resultsArray != null && !resultsArray.isEmpty()) {

			List<Description> descriptions = new ArrayList<Description>();
			for (Object[] results : resultsArray) {
				Description description = new Description();
				description.setId((long) results[0]);
				description.setTitle((String) results[1]);
				description.setImageId((Long) results[2]);
				description.setBlogId((Long) results[3]);
				description.setDate((Long) results[4]);
				descriptions.add(description);
			}
			return descriptions;
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Image> getImagesByIds(List<Long> imageIds) {
	     if (imageIds.isEmpty()) {
	    	 System.err.println("Image Ids empty");
	            return new ArrayList<>(); // Return an empty list if imageIds is empty
	        }
	        String hql = "FROM Image i WHERE i.id IN (:imageIds)";
	        return (List<Image>) hibernateTemplate.findByNamedParam(hql, "imageIds", imageIds);
	    
	}
	 @SuppressWarnings("deprecation")
	public void deleteBlogORNewsDescriptions(long blogId) {
	        String hql = "SELECT d.id, d.imageId FROM Description d WHERE d.blogId = :blogId";
	        @SuppressWarnings("unchecked")
			List<Object[]> resultsArray = (List<Object[]>) hibernateTemplate.findByNamedParam(hql, "blogId", blogId);

	        if (resultsArray != null && !resultsArray.isEmpty()) {
	            List<Long> descriptionIds = new ArrayList<>();
	            List<Long> imageIds = new ArrayList<>();

	            for (Object[] results : resultsArray) {
	                descriptionIds.add((Long) results[0]);
	                imageIds.add((Long) results[1]);
	            }

	            try {
	                if (!descriptionIds.isEmpty()) {
	                    // Delete descriptions
	                    String hqlDeleteDescriptions = "DELETE FROM Description d WHERE d.id IN (:descriptionIds)";
	                  org.hibernate.Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(hqlDeleteDescriptions);
	                  query.setParameterList("descriptionIds", descriptionIds);
	                  long count = query.executeUpdate();
	                    System.out.println("Deleted description count: " + count);
	                }

	                if (!imageIds.isEmpty()) {
	                    // Delete images
	                    String hqlDeleteImages = "DELETE FROM Image i WHERE i.id IN (:imageIds)";
	                    org.hibernate.Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(hqlDeleteImages);
	                    query.setParameterList("imageIds", imageIds);
	                    long deletedImageCount = query.executeUpdate();
	                    System.out.println("Deleted image count: " + deletedImageCount);
	                }
	            } catch (Exception e) {
	            	System.out.println("Descriptions not found to delete.");
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("Descriptions not found to delete.");
	        }
	    }

	public void deleteEntityById(String entityId) {
	    String hqlDeleteImages = "DELETE FROM BlogOrNews i WHERE i.id = (:entityId)";
		org.hibernate.Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(hqlDeleteImages);
		query.setParameter("entityId", entityId);
		long count = query.executeUpdate();
        System.out.println("Deleted entity count: " + count);
	}

	public void deleteDescriptionAndImageById(String descriptionId) {
		   // Delete the description by its id
        Description description = hibernateTemplate.get(Description.class, descriptionId);
        if (description != null) {
            hibernateTemplate.delete(description);
            System.out.println("Deleted description with id: " + descriptionId);
        } else {
            System.out.println("Description with id " + descriptionId + " not found.");
        }
		
	}

	public void deleteDescriptionImage(long imageId) {
		// Delete Image by image id 
		Image image = hibernateTemplate.get(Image.class, imageId);
	    if (image != null) {
            hibernateTemplate.delete(image);
            System.out.println("Deleted Image with id: " + imageId);
        } else {
            System.out.println("Image with id " + imageId + " not found.");
        }
	}

	public BlogOrNews getBlogOrNewsById(long entityId) {
		BlogOrNews blogOrNews = hibernateTemplate.get(BlogOrNews.class, entityId);
		if(blogOrNews != null) {
			return blogOrNews;
		}else {
			System.err.println("BlogOrNews not found with id : "+entityId);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Description> getDescriptionsBYBlogId(long blogId) {
		return (List<Description>) hibernateTemplate.findByNamedParam(
                "FROM Description d WHERE d.blogId = :blogId", "blogId", blogId);
	}

	public List<BlogOrNews> getAllBlockAndNews(Long pageNumber, Long pageSize) {
			String  sqlQuery = "select id, category , date , subCategory, title, type from blogornews LIMIT "+pageSize;
		    NativeQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sqlQuery);
		    List<Object[]> results =  query.list();
		    if(results != null && !results.isEmpty()) {
		    	List<BlogOrNews> blogOrNewsList = new ArrayList<BlogOrNews>();
		    	for(Object[] result : results) {
		    		BlogOrNews  blogOrNews = new BlogOrNews();
		    		
		    		BigInteger bigInteger = (BigInteger) result[0];
		    		blogOrNews.setId(bigInteger.longValue());
		    		
		    		BigInteger category  = (BigInteger) result[1];
		    		blogOrNews.setCategory(category.longValue());
		    		
		    		BigInteger date  = (BigInteger) result[2];
		    		blogOrNews.setDate(date.longValue());
		    		
		    		BigInteger subCategory  = (BigInteger) result[3];
		    		blogOrNews.setSubCategory(subCategory.longValue());
		    		
		    		blogOrNews.setTitle((String) result[4]);
		    		
		    		blogOrNews.setType((int) result[5]);
		    		
		    		blogOrNewsList.add(blogOrNews);
		    	}
		    	return blogOrNewsList;
		    }
		    return 	null;
	}
}
