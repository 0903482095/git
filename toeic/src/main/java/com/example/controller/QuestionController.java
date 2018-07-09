package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.model.QuestionDTO;
import com.example.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping
	public String Default(ModelMap modelMap) {
		List<QuestionDTO> questionDTOs = questionService.getAllQuestionDTO();
		modelMap.addAttribute("questionDTOs", questionDTOs);
		QuestionDTO dto = new QuestionDTO();
		modelMap.addAttribute("question", dto);

		return "question";
	}

	@PostMapping
	public String addQuestion(@ModelAttribute(name = "question") QuestionDTO questionDTO, ModelMap modelMap) {
		if (questionDTO.getId() > 0) {
			questionService.updateQuestion(questionDTO);
		} else {
			questionService.addQuestion(questionDTO);
		}

		return "redirect:/question";
	}

	@GetMapping("/{id}")
	public String getQuestion(@PathVariable int id, ModelMap modelMap) {
		List<QuestionDTO> questionDTOs = questionService.getAllQuestionDTO();
		modelMap.addAttribute("questionDTOs", questionDTOs);
		QuestionDTO questionDTO = questionService.getQuestionById(id);
		modelMap.addAttribute("question", questionDTO);
		return "question";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		questionService.deleteQuestion(id);
		return "redirect:/question";
	}
//	@PostMapping("/addquiz")
//	public String addQuiz(@ModelAttribute(name="questionDTOs") List<QuestionDTO> questionDTOs){
//		questionDTOs.forEach(questionDTO->{
//			System.out.println(questionDTO.isCheck());
//		});
//		return "redirect:/question";
//	}
	
}
