package com.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entity.EmployeeEntity;

import com.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

	public EmployeeEntity updateEmployee(long empId, EmployeeEntity employeeDetails) {
		if (employeeRepository.findById(empId).isPresent()) {
			EmployeeEntity existingEmployee = employeeRepository.findById(empId).get();

			existingEmployee.setName(employeeDetails.getName());
			existingEmployee.setDateOfBirth(employeeDetails.getDateOfBirth());
			existingEmployee.setSalary(employeeDetails.getSalary());
			existingEmployee.setAddress(employeeDetails.getAddress());
			existingEmployee.setRoleTitle(employeeDetails.getRoleTitle());
			existingEmployee.setJoiningDate(employeeDetails.getJoiningDate());
			existingEmployee.setYearlyBonusPercentage(employeeDetails.getYearlyBonusPercentage());
			existingEmployee.setReportingManagerId(employeeDetails.getReportingManagerId());

			return employeeRepository.save(existingEmployee);
		} else {
			throw new RuntimeException("Employee not found with ID: " + empId);
		}
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployeeById(Long empId) {
		employeeRepository.deleteById(empId);
	}

	@Override
	public EmployeeEntity getEmployeeById(Long empId) {
		EmployeeEntity employee = employeeRepository.findById(empId).orElse(null);
		if (employee != null) {
			return employee;
		} else {
			throw new RuntimeException("Employee not found with ID: " + empId);
		}
	}

}
