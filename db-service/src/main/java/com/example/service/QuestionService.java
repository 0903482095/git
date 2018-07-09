package com.example.service;

import java.util.List;

import com.example.model.QuestionDTO;

public interface QuestionService {
	public List<QuestionDTO> getAllQuestionDTO();

	public QuestionDTO getQuestionById(int id);

	public void deleteQuestion (int id);

	public void updateQuestion(QuestionDTO questionDTO);

	public void addQuestion(QuestionDTO questionDTO);

	public List<QuestionDTO> getQuestionByListId(List<Integer> id);
}
