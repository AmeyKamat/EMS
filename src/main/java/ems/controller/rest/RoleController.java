package ems.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ems.entity.Role;
import ems.service.RoleService;

@RestController
@RequestMapping(value="/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public @ResponseBody List<Role> getAllRoles(ModelMap model){
		return roleService.getAllRoles();
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public @ResponseBody Role getRoleById(@RequestParam("roleId") int roleId){
		return roleService.getRoleById(roleId);
	}
	
}
