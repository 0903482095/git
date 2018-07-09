package com.example.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.QuizDao;
import com.example.entity.Quiz;

@Transactional
@Repository
public class QuizDaoImpl implements QuizDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Quiz> getAllQuiz() {
		String sql = "SELECT q FROM Quiz q";
		return entityManager.createQuery(sql, Quiz.class).getResultList();
	}

	@Override
	public Quiz getQuizById(int id) {

		return entityManager.find(Quiz.class, id);
	}

	@Override
	public void addQuiz(Quiz quiz) {
		entityManager.persist(quiz);

	}

	@Override
	public void updateQuiz(Quiz quiz) {
		entityManager.merge(quiz);

	}

	@Override
	public void deleteQuiz(Quiz quiz) {
		entityManager.remove(quiz);

	}

}
