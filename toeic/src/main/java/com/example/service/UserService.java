package com.example.service;

import java.util.List;

import com.example.model.UserDTO;

public interface UserService {
	public List<UserDTO> getAllUserDTO();

	public UserDTO getUserById(int id);

	public void deleteUser(int id);

	public void updateUser(UserDTO userDTO);

	public void addUser(UserDTO userDTO);

	public List<UserDTO> getAllUserDTOByIdRole(int id);
}
