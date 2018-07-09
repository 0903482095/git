package com.example.service;

import java.util.List;

import com.example.model.AnswerDTO;

public interface AnswerService {
	public List<AnswerDTO> getAllAnswer();

	public void addAnswer(AnswerDTO answerDTO);

	public void updateAnswer(AnswerDTO answerDTO);

	public void deleteAnswer(int id);

	public List<AnswerDTO> getAnswerByIdQuestion(int id);
}
