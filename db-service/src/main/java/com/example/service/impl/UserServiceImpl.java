package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.model.UserDTO;
import com.example.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public List<UserDTO> getAllUserDTO() {
		List<UserDTO> listUserDTOs = new ArrayList<UserDTO>();
		List<User> listUsers = userDao.getAllUser();
		listUsers.forEach(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setPassword(user.getPassword());
			userDTO.setNamerole(user.getRole().getName());
			userDTO.setRoleId(user.getRole().getId());

			listUserDTOs.add(userDTO);
		});
		return listUserDTOs;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user=userDao.getUserById(id);
		UserDTO userDTO=new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setNamerole(user.getRole().getName());
		userDTO.setRoleId(user.getRole().getId());
		return userDTO;
	}

	@Override
	public void deleteUser(int id) {
		User user=userDao.getUserById(id);
		if(user!=null) {
			userDao.deleteUser(user);
		}
		
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user=userDao.getUserById(userDTO.getId());
//		PasswordEncoder encoder=new BCryptPasswordEncoder();
		if(user!=null) {
			user.setUsername(userDTO.getUsername());
			user.setEmail(userDTO.getEmail());
			user.setPassword(userDTO.getPassword());
			user.setRole(new Role(userDTO.getRoleId()));
			
			userDao.updateUser(user);
		}
		

	}

	@Override
	public void addUser(UserDTO userDTO) {
//		PasswordEncoder encoder=new BCryptPasswordEncoder();
		User user=new User();
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setRole(new Role(userDTO.getRoleId()));
		userDao.addUser(user);

	}

	@Override
	public List<UserDTO> getAllUserDTOByIdRole(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
