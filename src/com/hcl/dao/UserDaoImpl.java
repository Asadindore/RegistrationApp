package com.hcl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.hcl.model.User;

public class UserDaoImpl implements UserDao {
    @Autowired
	SessionFactory sessionfactory;
	@Override
	public void register(User user) {
	
	sessionfactory.getCurrentSession().save(user);

	}
	
	@Override
	public List<User> getAllUser() {
		
		return sessionfactory.getCurrentSession().createSQLQuery("select * from User").list();
	}

	@Override
	public User updateUser(User user) {
	
		sessionfactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getById(int user_id) {
		return (User) sessionfactory.getCurrentSession().get(User.class, user_id);
		
	}

	@Override
	public void delete(Integer user_id) {
		
		User user=(User)sessionfactory.getCurrentSession().load(User.class, user_id);
		if(user!=null)
		{
			this.sessionfactory.getCurrentSession().delete(user);
		}
	}
	

}
