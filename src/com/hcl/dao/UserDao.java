package com.hcl.dao;

import java.util.List;

import com.hcl.model.User;

public interface UserDao {
	
	public void register(User user);
	public List<User> getAllUser();
	public User updateUser(User user);
	public User getById(int user_id);
	public void delete(Integer user_id);

}
