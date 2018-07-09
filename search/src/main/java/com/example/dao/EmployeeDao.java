package com.example.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	@Transactional
	@Query("select e from Employee e where e.phone like ?1")
	public Employee getEmployeeByPhone(String phone);
	
}
