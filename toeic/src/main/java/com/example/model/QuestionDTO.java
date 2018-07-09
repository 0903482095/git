package com.example.model;

import java.util.List;

public class QuestionDTO {
	int id;
	String content;
	List<AnswerDTO> listAnswerDTOs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<AnswerDTO> getListAnswerDTOs() {
		return listAnswerDTOs;
	}

	public void setListAnswerDTOs(List<AnswerDTO> listAnswerDTOs) {
		this.listAnswerDTOs = listAnswerDTOs;
	}

	
}
