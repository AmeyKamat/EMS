package ems.service;

import java.util.List;

import ems.entity.Role;

public interface RoleService {
	public Role getRoleById(int roleId);
	public List<Role> getAllRoles();
}
