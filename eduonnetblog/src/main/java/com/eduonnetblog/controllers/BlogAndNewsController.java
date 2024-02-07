package com.eduonnetblog.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eduonnetblog.entities.BlogOrNews;
import com.eduonnetblog.entities.BlogOrNewsResObj;
import com.eduonnetblog.entities.Description;
import com.eduonnetblog.entities.Image;
import com.eduonnetblog.services.BlogAndNewsService;
import com.eduonnetblog.utilities.CommonConstansts;
import com.eduonnetblog.utilities.MWorkBlogUtility;

import net.sf.json.JSONObject;

@Controller
public class BlogAndNewsController {
	
	@Autowired
	BlogAndNewsService blogAndNewsService;

	
	@RequestMapping(value = "/saveblogornews", method = RequestMethod.POST)
	public void saveBlogOrNews(HttpServletResponse response, @RequestBody BlogOrNewsReqObj request) throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			BlogOrNews blogOrNews = BlogOrNewsReqObj.getEntity(request);
			List<Description> descriptions = request.getDescriptions();			
			blogAndNewsService.saveBlogOrNews(blogOrNews);
			for(Description description : descriptions) {
				description.setBlogId(blogOrNews.getId());
			}
			
			blogAndNewsService.saveDescriptions(descriptions);

			jsonObject.put(CommonConstansts.STATUS, true);
		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}
	
	@PostMapping("/uploadimage")
	public void handleFileUpload(HttpServletResponse response, @RequestParam("file") MultipartFile file) throws IOException {
		JSONObject jsonObject = new JSONObject();
		try {
			Image image = new Image();
		    image.setImageName(file.getOriginalFilename());
            image.setData(file.getBytes());
            blogAndNewsService.saveImage(image);
            jsonObject.put(CommonConstansts.DATA, image);
            jsonObject.put(CommonConstansts.STATUS, true);

		} catch (Exception e) {
			jsonObject = MWorkBlogUtility.handleException(jsonObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, jsonObject.toString());
	}
}
