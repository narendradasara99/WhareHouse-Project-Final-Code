package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.EmailUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private EmailUtil emailUtil;
	
	//1. Show Register Page
	@RequestMapping("/register")
	public String showReg() {
		return "UserRegister";
	}
	
	//2. on /save, read Form Data (POST)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(
			@ModelAttribute User user,
			ModelMap map)
	{
		String pwd=user.getUserPwd();
		Integer id=service.saveUser(user);
		String message="user saved with id:"+id;
		
		//email start//
		String text=" Hello!, User:"+user.getUserName()
		+" , Now you are part of Warehouse "
		+" , Your LoginId is:"+user.getUserEmail()
		+" , Password is:"+pwd
		+" , Roles : "+user.getRoles();

		boolean status=emailUtil.send(user.getUserEmail(),"Welcome to Warehouse",text);
		//email ends//
		if(status)
			message+=",Email also sent!";
		else 
			message+=",Email is not sent!";
		map.addAttribute("message",message);
		
		return "UserRegister";
	}
	 //3. Show Login Page
	@RequestMapping("/login")
	public String showLogin(
			) 
	{
		return "UserLogin";
	}
	
}





