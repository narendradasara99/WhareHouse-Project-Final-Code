package com.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserDao dao;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//read model class object
		com.app.model.User user=dao.getUserByEmail(username);
		//read roles
		Set<String> roles=user.getRoles();
		//create Set<GA>  // Type Inference-JDK1.7
		Set<GrantedAuthority> auths=new HashSet<>();  
		//model class user roles -> Set<GA>
		for(String role:roles) {
			auths.add(new SimpleGrantedAuthority(role));
		}
		//return Spring F/w User
		return new User(username, user.getUserPwd(), auths);
	}

}