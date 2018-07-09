package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;
import com.example.model.EmployeeDTO;
import com.example.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public EmployeeDTO getEmployeeById(Integer id) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Optional<Employee> employeeOptional = employeeDao.findById(id);
		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			employeeDTO.setId(employee.getId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setPhone(employee.getPhone());
		}

		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> employees = (List<Employee>) employeeDao.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		employees.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employee.getId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setPhone(employee.getPhone());

			employeeDTOs.add(employeeDTO);
		});
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO getEmployeeByPhone(String phone) {
		Employee employee = employeeDao.getEmployeeByPhone(phone);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setPhone(employee.getPhone());
		return employeeDTO;
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	public List<Employee> listAllByPage(int page) {
		List<Employee> employees=new ArrayList<Employee>();
		
		Page<Employee> pageEmployee = employeeDao.findAll(PageRequest.of(--page, 3,Direction.ASC,"name"));
		pageEmployee.forEach(employee->{
			employees.add(employee);
		});
		return employees;
	}

	

}
