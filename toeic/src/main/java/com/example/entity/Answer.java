package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String answer;
	boolean is_correct;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	Question question;

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
