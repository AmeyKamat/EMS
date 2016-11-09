package ems.repository;

import java.util.List;

import ems.entity.Role;

public interface RoleRepository {
	public Role getRoleById(int roleId);
	public List<Role> getAllRoles();
}
