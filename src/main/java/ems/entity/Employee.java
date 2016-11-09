package ems.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ems.util.JsonDateSerializer;

@Entity(name="employee")
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="kinId")
	private String kinId;
	
	@Column(name="emailId", unique=true)
	private String emailId;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="dateOfBirth")
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateOfBirth;
	
	@Column(name="dateOfJoining")
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateOfJoining;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;
	
	public Employee() {}
	
	public Employee(String name, String kinId, String emailId, String phoneNumber, Date dateOfBirth,
			Date dateOfJoining, String address, Department department, Project project, Role role) {
		super();
		this.name = name;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.address = address;
		this.department = department;
		this.project = project;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKinId() {
		return kinId;
	}

	public void setKinId(String kinId) {
		this.kinId = kinId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	
	
}
