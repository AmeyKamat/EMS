package ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.entity.Department;
import ems.repository.DepartmentRepository;
import ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(){}

	@Override
	public Department getDepartmentById(int departmentId) {
		return departmentRepository.getDepartmentById(departmentId);
	}
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.getAllDepartments();
	}
}
