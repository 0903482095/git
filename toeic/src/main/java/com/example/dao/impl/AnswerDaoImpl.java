package com.example.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AnswerDao;
import com.example.entity.Answer;

@Repository
@Transactional
public class AnswerDaoImpl implements AnswerDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Answer> getAllAnswer() {
		String sql = "SELECT a FROM Answer a";
		return entityManager.createQuery(sql, Answer.class).getResultList();
	}

	@Override
	public void addAnswer(Answer answer) {
		entityManager.persist(answer);

	}

	@Override
	public void updateAnswer(Answer answer) {
		entityManager.merge(answer);

	}

	@Override
	public void deleteAnswer(Answer answer) {
		entityManager.remove(answer);

	}

	@Override
	public List<Answer> getAnswerByIdQuestion(int id) {
		String sql = "SELECT a FROM Answer a where a.question.id=" + id;
		return entityManager.createQuery(sql, Answer.class).getResultList();
	}

}
