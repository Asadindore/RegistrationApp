package com.hcl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(value="/")
	public String home(){
		
		return "index";
	}
//@RequestMapping(value="/register", method=RequestMethod.POST)
//public ModelAndView register(@ModelAttribute User user)
//{
//	return new ModelAndView("register");
//}
@RequestMapping(value="/list")
public ModelAndView listUser(ModelAndView model)throws IOException
{
	List<User> listU=service.getAllUser();
	model.addObject("listUser", listU);
	
	return new ModelAndView("list");
}
@RequestMapping(value="/editDetails", method=RequestMethod.GET)
public ModelAndView editUser(HttpServletRequest request)
{
	int userid=Integer.parseInt(request.getParameter("user_id"));
	User user=service.getById(userid);
	ModelAndView model=new ModelAndView("index");
	model.addObject("listUser", user);
	return model;
}
@RequestMapping(value="/register", method=RequestMethod.POST)
public ModelAndView updateUser(@ModelAttribute User user)
{
	if(user.getUser_id()==0)
	{
		service.register(user);
	}
	else{
		service.updateUser(user);
	}
	return new ModelAndView("redirect:/");
}

public ModelAndView delete(HttpServletRequest request)
{
	int userid=Integer.parseInt(request.getParameter("user_id"));
	service.delete(userid);

	return new ModelAndView("redirect:/");
}
}
