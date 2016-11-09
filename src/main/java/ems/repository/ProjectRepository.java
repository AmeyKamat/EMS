package ems.repository;

import java.util.List;

import ems.entity.Department;
import ems.entity.Project;

public interface ProjectRepository {
	public Project getProjectById(int projectId);
	public List<Project> getProjectsByDepartment(Department department);
	public List<Project> getAllProjects();
}
