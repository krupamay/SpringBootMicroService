package com.metademy.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metademy.microservices.dao.UsersDao;
import com.metademy.microservices.model.User;

@Service
public class UserServiceImpl implements UserService {

	private final UsersDao usersDao;

	@Autowired
	UserServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public User saveUserInformation(User user) {
		usersDao.saveUserInformation(user);
		return user;
	}

}
