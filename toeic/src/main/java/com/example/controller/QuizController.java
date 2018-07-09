package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.QuizDTO;
import com.example.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;

	@GetMapping
	public String Default(ModelMap modelMap) {
		List<QuizDTO> listQuizDTOs = quizService.getAllQuizDTO();
		modelMap.addAttribute("listQuizDTOs", listQuizDTOs);
		modelMap.addAttribute("quiz", new QuizDTO());
		return "quiz";
	}
}
