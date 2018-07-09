package com.example.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.model.SearchUserDTO;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<User> getAllUser() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public User getUserById(int id) {

		return entityManager.find(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public List<User> getAllUserByIdRole(int id) {
		String sql = "SELECT u FROM User u where u.role.id= " + id;
		return entityManager.createQuery(sql, User.class).getResultList();
	}

	@Override
	public List<User> findUser(SearchUserDTO searchUserDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		Join<User, Role> roleJoin = root.join("role");
		if (searchUserDTO.getEmail() != null) {
			criteriaQuery.where(builder.like(builder.lower(root.get("email")), "%" + searchUserDTO.getKeyword() + "%"));
		}
		if (searchUserDTO.getRoleId() != null) {
			criteriaQuery.where(builder.equal(roleJoin.get("id"), "%" + searchUserDTO.getRoleId() + "%"));
		}
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		if (searchUserDTO.getPage() != null && searchUserDTO.getPageSize() != null) {
			typedQuery.setFirstResult((searchUserDTO.getPage() - 1) * searchUserDTO.getPageSize());
			typedQuery.setMaxResults(searchUserDTO.getPageSize());
		}

		return typedQuery.getResultList();
	}

	@Override
	public User getUserByUsername(String username) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("username"),username));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

}
