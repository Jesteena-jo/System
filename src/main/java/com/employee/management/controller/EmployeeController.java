package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.entity.EmployeeEntity;
import com.employee.management.service.DepartmentService;
import com.employee.management.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/employees")
	public String viewEmployee(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employee";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		EmployeeEntity employee = new EmployeeEntity();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentService.getAllDepartments()); // If departments exist
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute EmployeeEntity employee) {
		employeeService.createEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		EmployeeEntity employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "update_employee"; 
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute EmployeeEntity employee) {
		employeeService.createEmployee(employee); 
		return "redirect:/employees"; 
	}
}
