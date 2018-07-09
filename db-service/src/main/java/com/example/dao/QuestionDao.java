package com.example.dao;

import java.util.List;

import com.example.entity.Question;

public interface QuestionDao {
	public List<Question> getAllQuestion();

	public void addQuestion(Question question);

	public void updateQuestion(Question question);

	public void deleteQuestion(Question question);
	
	public Question getQuestionById(int id);
	
	public List<Question> getQuestionByListId(List<Integer> id);
}
