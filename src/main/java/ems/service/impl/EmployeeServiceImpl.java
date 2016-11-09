package ems.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.entity.Employee;
import ems.repository.EmployeeRepository;
import ems.service.DepartmentService;
import ems.service.EmployeeService;
import ems.service.ProjectService;
import ems.service.RoleService;
import ems.util.Util;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void addEmployee(Map<String, String> additionRecord) throws NumberFormatException, ParseException {
		Employee employeeObject = new Employee(
				additionRecord.get("name"),
				"", //kinId field is obsolete
				additionRecord.get("emailId"),
				additionRecord.get("phoneNumber"),
				Util.getDateFromString(additionRecord.get("dateOfBirth")),
				new Date(),
				additionRecord.get("address"),
				departmentService.getDepartmentById(Integer.parseInt(additionRecord.get("departmentId"))),
				projectService.getProjectById(Integer.parseInt(additionRecord.get("projectId"))),
				roleService.getRoleById(Integer.parseInt(additionRecord.get("roleId")))
			);
		
		employeeRepository.addEmployee(employeeObject);
	}

	@Override
	public void removeEmployee(int employeeId) {
		employeeRepository.removeEmployee(employeeId);		
	}

	@Override
	public void modifyEmployee(Map<String, String> modificationRecord) {
		int employeeId = Integer.parseInt(modificationRecord.get("employeeId"));
		Employee employee = employeeRepository.getEmployeeById(employeeId);
		
		setEmployeeAddress(employee, modificationRecord.get("address"));
		setEmployeeDepartment(employee, modificationRecord.get("departmentId"));
		setEmployeePhoneNumber(employee, modificationRecord.get("phoneNumber"));
		setEmployeeProject(employee, modificationRecord.get("projectId"));
		setEmployeeRole(employee, modificationRecord.get("roleId"));
		
		employeeRepository.modifyEmployee(employee);
	}
	
	private void setEmployeeAddress(Employee employee, String address){
		if(!address.equals("")){
			employee.setAddress(address);
		}
	}
	
	private void setEmployeePhoneNumber(Employee employee, String phoneNumber){
		if(!phoneNumber.equals("")){
			employee.setPhoneNumber(phoneNumber);
		}
	}
	
	private void setEmployeeDepartment(Employee employee, String departmentId) {
		if(!departmentId.equals("")){
			employee.setDepartment(departmentService.getDepartmentById(Integer.parseInt(departmentId)));
		}
	}
	
	private void setEmployeeProject(Employee employee, String projectId) {
		if(!projectId.equals("")){
			employee.setProject(projectService.getProjectById(Integer.parseInt(projectId)));
		}
	}
	
	private void setEmployeeRole(Employee employee, String roleId) {
		if(!roleId.equals("")){
			employee.setRole(roleService.getRoleById(Integer.parseInt(roleId)));
		}
	}

	@Override
	public List<Employee> searchEmployee(Map<String, String> keys) {
		Set<Employee> employees = new HashSet<Employee>();
		
		String name = keys.get("name");
		String emailId = keys.get("emailId");
		int employeeId;
		
		try{
			employeeId = Integer.parseInt(keys.get("employeeId"));
		}
		catch(NumberFormatException e){
			employeeId = -1;
		}
		
		employees.addAll(employeeRepository.getEmployeesByName(name));
		employees.add(employeeRepository.getEmployeeByEmailId(emailId));
		employees.add(employeeRepository.getEmployeeById(employeeId));
		
		return new LinkedList<Employee>(employees);
	}
	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

}
