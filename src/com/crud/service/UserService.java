package com.crud.service;

import java.util.List;
import com.crud.dao.UserDao;
import com.crud.model.User;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public List<User> list(String condition) {
		return userDao.queryUser(condition);
	}
}
