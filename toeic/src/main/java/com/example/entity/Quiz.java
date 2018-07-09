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
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "quiz_question", joinColumns = {
			@JoinColumn(name = "id_quiz", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_question", referencedColumnName = "id") })
	List<Question> listQuestions;

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

	public List<Question> getListQuestions() {
		return listQuestions;
	}

	public void setListQuestions(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}

}
