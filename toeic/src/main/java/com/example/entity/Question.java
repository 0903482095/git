package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String content;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	List<Answer> listAnswers;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "quiz_question", joinColumns = {
			@JoinColumn(name = "id_question", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_quiz", referencedColumnName = "id") })
	List<Quiz> listQuizs;

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

	public List<Quiz> getListQuizs() {
		return listQuizs;
	}

	public void setListQuizs(List<Quiz> listQuizs) {
		this.listQuizs = listQuizs;
	}

	public List<Answer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(List<Answer> listAnswers) {
		this.listAnswers = listAnswers;
	}

}
