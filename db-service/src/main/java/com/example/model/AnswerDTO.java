package com.example.model;

public class AnswerDTO {
	int id;
	String answer;
	boolean is_correct;
	int id_question;

	
	public AnswerDTO() {
		super();
	}

	public AnswerDTO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isIs_correct() {
		return is_correct;
	}

	public void setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}

	public int getId_question() {
		return id_question;
	}

	public void setId_question(int id_question) {
		this.id_question = id_question;
	}

}
