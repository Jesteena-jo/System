package com.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entity.DepartmentEntity;

import com.employee.management.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	

	@Override
	public DepartmentEntity addDepartment(DepartmentEntity department) {
		 return departmentRepository.save(department);
	}

	
	
	

	@Override
	public List<DepartmentEntity> getAllDepartments() {
		 return departmentRepository.findAll();
	}

	
	public DepartmentEntity getDepartmentById(Long id) {
	    DepartmentEntity dept = departmentRepository.findById(id).get();
	    return dept;
	}

	public void deleteDepartment(Long id) {
	    departmentRepository.deleteById(id);
	}
}
