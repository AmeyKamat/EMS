package ems.repository;

import java.util.List;

import ems.entity.Employee;


public interface EmployeeRepository {
	public void addEmployee(Employee employee);
	public void removeEmployee(int employeeId);
	public void modifyEmployee(Employee employee);
	public Employee getEmployeeByEmailId(String emailId);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getAllEmployees();
}
