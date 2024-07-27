package com.eduonnetblog.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;
import com.eduonnetblog.services.BlogAndNewsService;
import com.eduonnetblog.services.ImageCompressionService;
import com.eduonnetblog.utilities.CommonConstansts;
import com.eduonnetblog.utilities.MWorkBlogUtility;

import net.sf.json.JSONObject;

@Controller
public class BlogAndNewsController {

	@Autowired
	BlogAndNewsService blogAndNewsService;

	@Autowired
	ImageCompressionService compressionService;

	/**
	 * @author RAMESHWAR
	 * @param response
	 * @param request
	 * @throws IOException
	 * @description This method will save the blog or news object
	 */
	@RequestMapping(value = "/saveblogornews", method = RequestMethod.POST)
	public void saveBlogOrNews(HttpServletResponse response, @RequestBody BlogOrNewsReqObj request) throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			BlogOrNews blogOrNews = BlogOrNewsReqObj.getEntity(request);
			Date date = new Date();
			blogOrNews.setDate(date.getTime());
			List<Description> descriptions = request.getDescriptions();
			blogAndNewsService.saveBlogOrNews(blogOrNews);
			for (Description description : descriptions) {
				description.setBlogId(blogOrNews.getId());
				description.setDate(date.getTime());
			}
			blogAndNewsService.saveDescriptions(descriptions);

			jsonObject.put(CommonConstansts.STATUS, true);
			jsonObject.put(CommonConstansts.DATA, blogOrNews.getId());

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	/**
	 * @author RAMESHWAR
	 * @apiNote update only Blog or news entity.
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateBlogornews", method = RequestMethod.POST)
	public void updateBlogOrNews(HttpServletResponse response, @RequestBody BlogOrNewRequestObj request)
			throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			BlogOrNews blogOrNews = BlogOrNewRequestObj.getEntity(request);
			Date date = new Date();
			blogOrNews.setDate(date.getTime());

			blogAndNewsService.saveBlogOrNews(blogOrNews);

			jsonObject.put(CommonConstansts.STATUS, true);
			jsonObject.put(CommonConstansts.DATA, JSONObject.fromObject(blogOrNews));

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	@PostMapping("/uploadimage")
	public void handleFileUpload(HttpServletResponse response, @RequestParam("file") MultipartFile file)
			throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			Image image = new Image();
			Date date = new Date();
			image.setDate(date.getTime());
			image.setImageName(file.getOriginalFilename());
			System.out.println("Original file size " + file.getBytes().length);

			byte[] compressedImage = compressionService.compress(file.getBytes(), "jpg");
			System.out.println("Compress file size " + compressedImage.length);

			image.setData(compressedImage);
			blogAndNewsService.saveImage(image);
			jsonObject.put(CommonConstansts.DATA, image);
			jsonObject.put(CommonConstansts.STATUS, true);

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	@RequestMapping(value = "/deleteBlogOrNews", method = RequestMethod.POST)
	public void deleteEntity(HttpServletResponse response, @RequestBody JSONObject requestBody) throws IOException {

		String password = requestBody.getString("password");
		String blogOrNewId = requestBody.getString("blogOrNewId");
		JSONObject jsonObject = new JSONObject();
		try {
			if(StringUtils.hasText(password) && validatePassword(password)) {
				// delete all description
				blogAndNewsService.deleteBlogORNewsDescriptions(blogOrNewId);
				
				// delete entity
				blogAndNewsService.deleteEntityById(blogOrNewId);
				
				jsonObject.put(CommonConstansts.STATUS, true);
			}else {
				jsonObject.put(CommonConstansts.STATUS, false);
				jsonObject.put(CommonConstansts.ERROR_MESSAGE, "Password Varification Faild");
			}

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	private boolean validatePassword(String password) {
		if (password.equals("L4mGU`6_z]b59VKu$CagyY")) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/deleteDesc/{entityId}", method = RequestMethod.GET)
	public void deleteDesc(HttpServletResponse response, @PathVariable String entityId) throws IOException {

		JSONObject jsonObject = new JSONObject();
		try {
			// delete Description & images
			blogAndNewsService.deleteDescriptionAndImageById(entityId);
			jsonObject.put(CommonConstansts.STATUS, true);
		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	@RequestMapping(value = "/deleteImg/{imgId}", method = RequestMethod.GET)
	public void deleteImg(HttpServletResponse response, @PathVariable String imgId) throws IOException {

		JSONObject jsonObject = new JSONObject();
		try {
			blogAndNewsService.deleteDescriptionImage(imgId);
			jsonObject.put(CommonConstansts.STATUS, true);

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}

	@RequestMapping(value = "/getEntityWiseInfo/{entityId}", method = RequestMethod.GET)
	public void getEntityWiseInfo(HttpServletResponse response, @PathVariable String entityId) throws IOException {

		JSONObject jsonObject = new JSONObject();
		try {
			BlogOrNews entity = blogAndNewsService.getBlogOrNewsById(entityId);
			List<Description> descriptions;
			List<Image> images;

			if (entity != null) {
				jsonObject.put(CommonConstansts.STATUS, true);
				jsonObject.put(CommonConstansts.DATA, entity);
			}
			jsonObject.put(CommonConstansts.STATUS, false);
			jsonObject.put(CommonConstansts.ERROR_MESSAGE, "Entity not found");

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}


}
