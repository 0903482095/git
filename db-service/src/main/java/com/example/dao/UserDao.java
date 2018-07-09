package com.example.dao;

import java.util.List;
import com.example.entity.User;
import com.example.model.SearchUserDTO;

public interface UserDao {
	public List<User> getAllUser();

	public User getUserById(int id);

	public void deleteUser(User user);

	public void updateUser(User user);

	public void addUser(User user);
	
	public User getUserByUsername(String email);

	public List<User> getAllUserByIdRole(int id);

	public List<User> findUser(SearchUserDTO searchUserDTO);
	
	
}
