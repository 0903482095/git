package com.example.dao;

import java.util.List;

import com.example.entity.Quiz;

public interface QuizDao {
	public List<Quiz> getAllQuiz();

	public Quiz getQuizById(int id);

	public void addQuiz(Quiz quiz);

	public void updateQuiz(Quiz quiz);

	public void deleteQuiz(Quiz quiz);
}
