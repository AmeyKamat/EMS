package ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.entity.Role;
import ems.repository.RoleRepository;
import ems.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleServiceImpl(){}

	@Override
	public Role getRoleById(int roleId) {
		return roleRepository.getRoleById(roleId);
	}
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.getAllRoles();
	}

}
