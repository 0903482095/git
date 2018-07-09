package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.QuestionDao;
import com.example.entity.Question;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Question> getAllQuestion() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
		Root<Question> root = criteriaQuery.from(Question.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void addQuestion(Question question) {
		entityManager.persist(question);

	}

	@Override
	public void updateQuestion(Question question) {
		entityManager.merge(question);

	}

	@Override
	public void deleteQuestion(Question question) {
		entityManager.remove(question);

	}

	@Override
	public Question getQuestionById(int id) {

		return entityManager.find(Question.class, id);
	}

	@Override
	public List<Question> getQuestionByListId(List<Integer> id) {
		List<Question> questions = new ArrayList<Question>();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Question> criteriaQuery = builder.createQuery(Question.class);
		Root<Question> root = criteriaQuery.from(Question.class);
		id.forEach(i -> {
			criteriaQuery.select(root);
			criteriaQuery.where(builder.equal(root.get("id"), i));
			Question question = entityManager.createQuery(criteriaQuery).getSingleResult();
			questions.add(question);
		});
		return questions;
	}

}
