package ems.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ems.entity.Department;
import ems.service.DepartmentService;

@RestController
@RequestMapping(value="/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public @ResponseBody List<Department> getAllDepartments(ModelMap model){
		return departmentService.getAllDepartments();
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public @ResponseBody Department getRoleById(@RequestParam("departmentId") int departmentId){
		return departmentService.getDepartmentById(departmentId);
	}
	
}
