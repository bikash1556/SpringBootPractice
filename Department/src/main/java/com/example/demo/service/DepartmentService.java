package com.example.demo.service;

//Java Program to Demonstrate DepartmentService File

//Importing required package modules
import com.example.demo.entity.Department;
//Importing required classes
import java.util.List;

//Interface
public interface DepartmentService {

	// Save operation
	Department saveDepartment(Department department);

	// Read operation
	List<Department> fetchDepartmentList();

	// Update operation
	Department updateDepartment(Department department,
								Long departmentId);

	// Delete operation
	void deleteDepartmentById(Long departmentId);
}

