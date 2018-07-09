package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.QuizDTO;
import com.example.service.QuizService;

@RestController
@RequestMapping("/rest/db")
public class ApiController {
	@Autowired
	QuizService quizService;
	@GetMapping("/quizs")
	public ResponseEntity<List<QuizDTO>> getAllQuizs(){
		return new ResponseEntity<List<QuizDTO>>(quizService.getAllQuizDTO(),HttpStatus.OK);
	}
	@GetMapping("/quizs/{id}")
	public ResponseEntity<QuizDTO> getQuizsById(@PathVariable int id){
		return new ResponseEntity<QuizDTO>(quizService.getQuizDTOById(id),HttpStatus.OK);
	}
}
