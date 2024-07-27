package com.eduonnetblog.services;

import com.eduonnetblog.entities.User;

public interface UserService {

	User createUser(User user) throws Exception;

	void deleteUser(String userId);

	User updateUser(User user);

	User getUserById(String userId);

}
