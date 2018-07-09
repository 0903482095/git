package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.QuizDTO;
import com.example.service.QuizService;

@RestController
@RequestMapping("/rest/quizs")
public class RestTemplateController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public ResponseEntity<QuizDTO> getQuizsById(@PathVariable int id){
		ResponseEntity<QuizDTO> responseEntity=restTemplate.getForEntity("http://localhost:8080/quizs/"+id, QuizDTO.class);
		return responseEntity;
	}
}
