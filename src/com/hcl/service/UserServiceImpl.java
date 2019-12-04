package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sun.print.resources.serviceui;

import com.hcl.dao.UserDao;
import com.hcl.model.User;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;
	@Override
	public void register(User user) {
		dao.register(user);
	}
	public List<User> getAllUser()
	{
		return dao.getAllUser();
	}
	@Override
	public User updateUser(User user) {
		return dao.updateUser(user);
		
	}
	@Override
	public User getById(int user_id) {
		return dao.getById(user_id);
	}
	@Override
	public void delete(Integer user_id) {
		dao.delete(user_id);
		
	}

}
