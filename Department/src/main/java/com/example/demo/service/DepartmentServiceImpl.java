package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	Logger log=LoggerFactory.getLogger(DepartmentServiceImpl.class);
	 @Autowired
	    private DepartmentRepo departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("Inside ServiceImpl for Save Opertaion of departement");
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		log.info("Inside ServiceImpl for fetch Opertaion of departement");
		return (List<Department>)
				
	            departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		// TODO Auto-generated method stub
		Department depDB
        = departmentRepository.findById(departmentId)
              .get();

    if (Objects.nonNull(department.getDepartmentName())
        && !"".equalsIgnoreCase(
            department.getDepartmentName())) {
        depDB.setDepartmentName(
            department.getDepartmentName());
    }

    if (Objects.nonNull(
            department.getDepartmentAddress())
        && !"".equalsIgnoreCase(
            department.getDepartmentAddress())) {
        depDB.setDepartmentAddress(
            department.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode())
        && !"".equalsIgnoreCase(
            department.getDepartmentCode())) {
        depDB.setDepartmentCode(
            department.getDepartmentCode());
    }

    return departmentRepository.save(depDB);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
		
	}

}