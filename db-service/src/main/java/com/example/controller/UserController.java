	package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.UserDTO;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<UserDTO> listUserDTOs=userService.getAllUserDTO();
		modelMap.addAttribute("listUserDTOs", listUserDTOs);
		UserDTO userDTO=new UserDTO();
		modelMap.addAttribute("user", userDTO);
		return "user";
	}
	@PostMapping
	public String addUser(@ModelAttribute(name="user") UserDTO userDTO ) {
		if(userDTO.getId()>0) {
			userService.updateUser(userDTO);
		}
		else {
			userService.addUser(userDTO);
		}
		return "redirect:/user";
	}
	@GetMapping("/{id}")
	public String getUser(@PathVariable int id,ModelMap modelMap) {
		List<UserDTO> listUserDTOs=userService.getAllUserDTO();
		modelMap.addAttribute("listUserDTOs", listUserDTOs);
		if(userService.getUserById(id) !=null){
			modelMap.addAttribute("user", userService.getUserById(id));
		}
		
		return "user";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/user";
	}
	
}
