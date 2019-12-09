package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public Integer saveUser(User user) {
		//read UI Pwd
		String pwd=user.getUserPwd();
		//encode it
		pwd=encoder.encode(pwd);
		//set back to Model class obj
		user.setUserPwd(pwd);
		return dao.saveUser(user);
	}

}




