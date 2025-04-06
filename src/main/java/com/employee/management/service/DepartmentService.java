package com.employee.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.management.entity.DepartmentEntity;
@Service
public interface DepartmentService {

	DepartmentEntity addDepartment(DepartmentEntity department);

	void deleteDepartment(Long departmentId);
	
	DepartmentEntity getDepartmentById(Long id);
	
	List<DepartmentEntity> getAllDepartments();


}
