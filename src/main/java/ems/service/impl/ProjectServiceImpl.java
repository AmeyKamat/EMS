package ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.entity.Department;
import ems.entity.Project;
import ems.repository.ProjectRepository;
import ems.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project getProjectById(int projectId) {
		return projectRepository.getProjectById(projectId);
	}
	
	@Override
	public List<Project> getProjectsByDepartment(Department department) {
		return projectRepository.getProjectsByDepartment(department);
	}
	
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.getAllProjects();
	}

}
