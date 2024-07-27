package com.eduonnetblog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonnetblog.daos.UserDao;
import com.eduonnetblog.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public User createUser(User user) throws Exception{
		return userDao.createUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	@Transactional
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

}
