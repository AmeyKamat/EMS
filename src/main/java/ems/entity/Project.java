package ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "project")
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "projectId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public Project() {
	}

	public Project(int projectId, String name, String description, Department department) {
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.department = department;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
