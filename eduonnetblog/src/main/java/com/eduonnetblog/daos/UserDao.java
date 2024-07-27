package com.eduonnetblog.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.eduonnetblog.entities.User;

@Service
public class UserDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	public User createUser(User user) {
		hibernateTemplate.save(user);
		return user;
	}

	public void deleteUser(String userId) {
		User user = hibernateTemplate.get(User.class, userId);
		if(user != null) {
			hibernateTemplate.delete(user);
		}
	}

	public User updateUser(User user) {
		hibernateTemplate.update(user);
		return user;
	}

	public User getUserById(String userId) {
		return hibernateTemplate.get(User.class, userId);
	}

}
