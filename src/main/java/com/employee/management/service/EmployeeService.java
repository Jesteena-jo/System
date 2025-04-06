package com.employee.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.management.entity.EmployeeEntity;

@Service
public interface EmployeeService {
	EmployeeEntity createEmployee(EmployeeEntity employee);

	void deleteEmployeeById(Long empId);

	EmployeeEntity getEmployeeById(Long empId);

	List<EmployeeEntity> getAllEmployees();

}
