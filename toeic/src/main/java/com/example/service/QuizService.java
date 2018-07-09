package com.example.service;

import java.util.List;

import com.example.model.QuizDTO;

public interface QuizService {
	public List<QuizDTO> getAllQuizDTO();

	public QuizDTO getQuizDTOById(int id);

	public void addQuiz(QuizDTO quizDTO);

	public void updateQuiz(QuizDTO quizDTO);

	public void deleteQuiz(int id);
}
