package com.example.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.entity.Employee;
import com.example.model.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO getEmployeeById(Integer id);

	public List<EmployeeDTO> getAllEmployee();

	public EmployeeDTO getEmployeeByPhone(String phone);

	public void deleteEmployee(Integer id);
	
	public List<Employee> listAllByPage(int page);
	

}
