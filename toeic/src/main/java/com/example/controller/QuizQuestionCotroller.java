package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.QuizDTO;
import com.example.service.QuizService;

@Controller
@RequestMapping("/quizquestion")
public class QuizQuestionCotroller {
	@Autowired
	QuizService quizService;

	@GetMapping("/{id}")
	public String Default(ModelMap modelMap, @PathVariable int id) {
		QuizDTO quizDTO = quizService.getQuizDTOById(id);
		modelMap.addAttribute("quizDTO", quizDTO);
		return "quizquestion";
	}

}
