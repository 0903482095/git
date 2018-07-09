package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Employee;
import com.example.model.EmployeeDTO;
import com.example.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	int count=0;
	@GetMapping
	public String getAllEmployeeDTO(ModelMap modelMap) {
//		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
//		employeeDTOs = employeeService.getAllEmployee();
//		count=employeeService.getAllEmployee().size();
//		modelMap.addAttribute("employeeDTOs", employeeDTOs);
//		modelMap.addAttribute("count", count/3 + 1);
		return "employee";
	}
	@GetMapping("/delete/{idemployee}")
	public String deleteEmployee(@PathVariable int idemployee) {
		employeeService.deleteEmployee(idemployee);
		return "redirect:/employee";
	}
	@GetMapping("/page/{pagei}")
	public String getPageEmployee(@PathVariable int pagei,ModelMap modelMap) {
		count=employeeService.getAllEmployee().size();
		List<Employee> employees = employeeService.listAllByPage(pagei);
		
		modelMap.addAttribute("employeeDTOs", employees);
		modelMap.addAttribute("count", count/3 + 1);
		return "employee";
	}
	@GetMapping("/{phone}")
	public String getEmployee(@PathVariable String phone,ModelMap modelMap) {
		EmployeeDTO employeeDTO=employeeService.getEmployeeByPhone(phone);
		modelMap.addAttribute("employeeDTOs", employeeDTO);
		return "employee";
	}
}
