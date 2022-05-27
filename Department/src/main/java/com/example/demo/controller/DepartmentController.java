package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// Save operation
	@PostMapping("/departments")
	public Department saveDepartment(@Validated @RequestBody Department department) {
		log.info("Inside Controller for Save Opertaion of departement");
		return departmentService.saveDepartment(department);
	}

	// Read operation
	@GetMapping("/departments")
	public java.util.List<Department> fetchDepartmentList() {
		log.info("Inside Controller for fetch Opertaion of departement");
		return departmentService.fetchDepartmentList();
	}

	// Update operation
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		log.info("Inside Controller for update Opertaion of departement");
		return departmentService.updateDepartment(department, departmentId);
	}

	// Delete operation
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside Controller for delete Opertaion of departement");
		departmentService.deleteDepartmentById(departmentId);
		return "Deleted Successfully";
	}

}
