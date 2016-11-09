package ems.controller.rest;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ems.entity.Employee;
import ems.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees(ModelMap model){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public @ResponseBody List<Employee> searchEmployee(@RequestParam("employeeId") String employeeId,
												@RequestParam("name") String name,
												@RequestParam("emailId") String emailId){
		Map<String, String> searchRequest = new HashMap<String, String>();
		searchRequest.put("employeeId", employeeId);
		searchRequest.put("name", name);
		searchRequest.put("emailId", emailId);
		
		return employeeService.searchEmployee(searchRequest);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody void addEmployee(@RequestBody Map<String, String> requestParams) throws NumberFormatException, ParseException{
		employeeService.addEmployee(requestParams);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.DELETE)
	public @ResponseBody void removeEmployee(@RequestParam("employeeId") int employeeId){
		employeeService.removeEmployee(employeeId);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.PUT)
	public @ResponseBody void modifyEmployee(@RequestBody Map<String, String> requestParams){
		employeeService.modifyEmployee(requestParams);
		
	}
	
	
	
}