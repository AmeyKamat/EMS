package ems.service;

import java.util.List;

import ems.entity.Department;
import ems.entity.Project;

public interface ProjectService {
	public Project getProjectById(int projectId);
	public List<Project> getAllProjects();
	public List<Project> getProjectsByDepartment(Department department);
}
