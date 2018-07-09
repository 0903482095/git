package com.example.model;

import java.util.List;

public class QuizDTO {
	int id;
	String name;
	List<QuestionDTO> listQuestionDTOs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<QuestionDTO> getListQuestionDTOs() {
		return listQuestionDTOs;
	}

	public void setListQuestionDTOs(List<QuestionDTO> listQuestionDTOs) {
		this.listQuestionDTOs = listQuestionDTOs;
	}

}
