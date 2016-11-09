package ems.repository;

import java.util.List;

import ems.entity.Department;


public interface DepartmentRepository {
	public Department getDepartmentById(int departmentId);
	public List<Department> getAllDepartments();
}
