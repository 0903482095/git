package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import com.example.dao.UserDao;
@Service
@Transactional
public class UserLoginServiceImpl implements UserDetailsService{
	@Autowired
	UserDao userDao;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		com.example.entity.User user=userDao.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("no user");
		}
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		
		UserDetails details=new User(user.getUsername(),user.getPassword(), true, true, true, true, authorities);
		return details;
	}
}
