package ems.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ems.entity.Role;
import ems.repository.RoleRepository;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository{

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Role> getAllRoles() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Role.class).list();
	}
	
	@Override
	public Role getRoleById(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		return (Role)session.createCriteria(Role.class)
				.add(Restrictions.eq("roleId", roleId))
				.uniqueResult();
	}
}
