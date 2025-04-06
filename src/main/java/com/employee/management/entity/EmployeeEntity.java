package com.employee.management.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long empId;
    private String name;
    private LocalDate  dateOfBirth;
    private float salary;
    private String address;
    private String roleTitle;
    private LocalDate joiningDate;
    private float yearlyBonusPercentage;
    private int reportingManagerId;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity department;

    public EmployeeEntity() {}

    // Parameterized Constructor
    public EmployeeEntity(Long empId, String name, LocalDate  dateOfBirth, float salary, 
                          String address, String roleTitle, LocalDate  joiningDate, 
                          float yearlyBonusPercentage, int reportingManagerId, 
                          DepartmentEntity department) {
        this.empId = empId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.address = address;
        this.roleTitle = roleTitle;
        this.joiningDate = joiningDate;
        this.yearlyBonusPercentage = yearlyBonusPercentage;
        this.reportingManagerId = reportingManagerId;
        this.department = department;
    }

   
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate  getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate  dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public LocalDate  getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate  joiningDate) {
        this.joiningDate = joiningDate;
    }

    public float getYearlyBonusPercentage() {
        return yearlyBonusPercentage;
    }

    public void setYearlyBonusPercentage(float yearlyBonusPercentage) {
        this.yearlyBonusPercentage = yearlyBonusPercentage;
    }

    public int getReportingManagerId() {
        return reportingManagerId;
    }

    public void setReportingManagerId(int reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
    
}
