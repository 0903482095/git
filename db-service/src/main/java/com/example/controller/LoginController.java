package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String login(@RequestParam(name="e", required=false) String error,ModelMap map) {
		if(error!=null) {
			map.addAttribute("e",error);
		}
		return "login";
	}
}
