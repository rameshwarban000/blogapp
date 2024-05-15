package com.eduonnetblog.utilities;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class MWorkBlogUtility {

	
	public static void writeDatainResponce(HttpServletResponse response, String dataJson) throws IOException {
		 response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
	        response.setHeader("Cache-Control", "no-cache");
	        bufferedOutputStream.write(dataJson.getBytes("utf8"));
	        bufferedOutputStream.flush();
	}
	
	public static JSONObject handleException(JSONObject responseObject, Exception e) {
	    e.printStackTrace();
	    responseObject.put(CommonConstansts.STATUS, false);
	    responseObject.put(CommonConstansts.ERROR_MESSAGE, e.getMessage());
	    return responseObject;
	}

}
