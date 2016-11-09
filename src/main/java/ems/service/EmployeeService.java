package ems.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import ems.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Map<String, String> additionRecord) throws NumberFormatException, ParseException;
	public void removeEmployee(int employeeId);
	public void modifyEmployee(Map<String, String> modificationRecord);
	public List<Employee> searchEmployee(Map<String, String> keys);
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getAllEmployees();
}
