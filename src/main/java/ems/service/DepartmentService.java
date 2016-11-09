package ems.service;

import java.util.List;

import ems.entity.Department;


public interface DepartmentService {
	public Department getDepartmentById(int departmentId);
	public List<Department> getAllDepartments();
	
}