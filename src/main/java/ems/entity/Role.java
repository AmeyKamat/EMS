package ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="role")
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="roleId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public Role(){}
	
	public Role(int roleId, String name, String description) {
		this.roleId = roleId;
		this.name = name;
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}