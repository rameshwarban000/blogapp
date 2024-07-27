package com.eduonnetblog.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.eduonnetblog.entities.User;
import com.eduonnetblog.entities.UserRequestObj;
import com.eduonnetblog.services.UserService;
import com.eduonnetblog.utilities.CommonConstansts;
import com.eduonnetblog.utilities.MWorkBlogUtility;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public void createUser(@RequestBody UserRequestObj userRequestObj, HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			User user = UserRequestObj.prepareUser(userRequestObj);
			user = userService.createUser(user);
			responceObject.put(CommonConstansts.STATUS, true);
			responceObject.put(CommonConstansts.DATA, user);
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable String userId, HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			if(StringUtils.hasText(userId)) {
				userService.deleteUser(userId);
				responceObject.put(CommonConstansts.STATUS, true);
			}else {
				responceObject.put(CommonConstansts.STATUS, false);
				responceObject.put(CommonConstansts.ERROR_MESSAGE, "User Id nout found!");
			}
			
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@PostMapping("/updateUser")
	public void updateUser(@RequestBody UserRequestObj userRequestObj, HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			User user = UserRequestObj.prepareUser(userRequestObj);
			user = userService.updateUser(user);
			responceObject.put(CommonConstansts.STATUS, true);
			responceObject.put(CommonConstansts.DATA, user);
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@GetMapping("/getUserById/{userId}/")
	public void getUsersById(@PathVariable String userId, HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			if(StringUtils.hasText(userId)){
				User user = userService.getUserById(userId);
				responceObject.put(CommonConstansts.STATUS, true);
				responceObject.put(CommonConstansts.DATA, user);
			}else{
				responceObject.put(CommonConstansts.STATUS, false);
				responceObject.put(CommonConstansts.ERROR_MESSAGE, "User Id nout found!");
			}
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@PostMapping("/logInUser")
	public void logInUser(HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@PostMapping("/logOutUser")
	public void logOutUser(HttpServletResponse response) throws IOException {
		JSONObject responceObject = new JSONObject();
		try {
			
		} catch (Exception e) {
			MWorkBlogUtility.handleException(responceObject, e);
		}
		MWorkBlogUtility.writeDatainResponce(response, responceObject.toString());
	}
	
	@PostMapping("/forgotPassword")
	public void sendOtp() {
		
	}
	
	@PostMapping("/resetPassword")
	public void resetPassword(HttpServletResponse response){
		
	}
}
