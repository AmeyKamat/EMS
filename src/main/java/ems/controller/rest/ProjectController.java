package ems.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ems.entity.Department;
import ems.entity.Project;
import ems.service.DepartmentService;
import ems.service.ProjectService;

@RestController
@RequestMapping(value="/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public @ResponseBody Project getProjectById(@RequestParam("projectId") int projectId){
		return projectService.getProjectById(projectId);
	}
	
	@RequestMapping(value="/getByDepartment", method=RequestMethod.GET)
	public @ResponseBody List<Project> getProjectsByDepartment(@RequestParam("departmentId") int departmentId){
		Department department = departmentService.getDepartmentById(departmentId);
		return projectService.getProjectsByDepartment(department);
	}
}
