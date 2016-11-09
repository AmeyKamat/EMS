package ems.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ems.entity.Department;
import ems.repository.DepartmentRepository;

@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Department> getAllDepartments() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Department.class).list();
	}
	
	@Override
	public Department getDepartmentById(int departmentId){
		Session session = sessionFactory.getCurrentSession();
		return (Department)session.createCriteria(Department.class)
				.add(Restrictions.eq("departmentId", departmentId))
				.list().get(0);
	}
}
