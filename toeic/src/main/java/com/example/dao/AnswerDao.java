package com.example.dao;

import java.util.List;

import com.example.entity.Answer;

public interface AnswerDao {
	public List<Answer> getAllAnswer();

	public void addAnswer(Answer answer);

	public void updateAnswer(Answer answer);

	public void deleteAnswer(Answer answer);

	public List<Answer> getAnswerByIdQuestion(int id);
}
