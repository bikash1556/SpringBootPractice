package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepo;
import com.example.demo.service.DepartmentServiceImpl;

@SpringBootTest(classes = { Test_DepartmentService.class })
public class Test_DepartmentService {

	@Mock
	DepartmentRepo departmentRepo;

	@InjectMocks
	DepartmentServiceImpl departmentService;

	@Test
	@Order(1)
	public void test_fetchDepartmentList() {

		List<Department> departement = new ArrayList<Department>();
		departement.add(new Department(1L, "IST", "Ravenshaw", "IST001"));
		departement.add(new Department(2L, "ETC", "Ravenshaw", "ETC001"));

		when(departmentRepo.findAll()).thenReturn(departement);
		assertEquals(2, departmentService.fetchDepartmentList().size());
	}

	@Test
	@Order(2)
	public void test_saveDepartment() {

		Department departement = new Department(1L, "IST", "Ravenshaw", "IST001");

		when(departmentRepo.save(departement)).thenReturn(departement);
		assertEquals(1L, departement.getDepartmentId());
		assertEquals("IST", departement.getDepartmentName());
		assertEquals("Ravenshaw", departement.getDepartmentAddress());
	}

//	@Test
//	@Order(3)
//	public void test_updateDepartment() {
//
//		Department departement = new Department(1L, "IST", "Ravenshaw", "IST001");
//		//Department depDB = departmentRepository.findById(departmentId).get();
//
//		when(departmentRepo.save(departement)).thenReturn(departement);
//		assertEquals(departement,departmentService.updateDepartment(departement, 1L));
//
//	}

}
