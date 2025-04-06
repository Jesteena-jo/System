package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.entity.DepartmentEntity;
import com.employee.management.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public String viewDepartments(Model model) {
		model.addAttribute("listDepartments", departmentService.getAllDepartments());
		return "department";
	}

	@GetMapping("/departmentForm")
	public String showNewDepartmentForm(Model model) {
		DepartmentEntity department = new DepartmentEntity();
		model.addAttribute("department", department);
		return "new_department";
	}
	@GetMapping("/updateDepartment/{id}")
	public String showUpdateDepartmentForm(@PathVariable Long id, Model model) {
	    DepartmentEntity department = departmentService.getDepartmentById(id);
	    model.addAttribute("department", department);
	    return "update_department"; 
	}
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute DepartmentEntity department) {
	    departmentService.addDepartment(department);
	    return "redirect:/departments";
	}
	@GetMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable Long id) {
	    departmentService.deleteDepartment(id);
	    return "redirect:/departments";
	}
}
