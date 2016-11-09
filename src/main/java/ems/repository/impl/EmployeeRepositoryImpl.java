package ems.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ems.entity.Employee;
import ems.repository.EmployeeRepository;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee){
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public void removeEmployee(int employeeId) {
		
		Session session = sessionFactory.getCurrentSession();
		Employee result = (Employee)session.createCriteria(Employee.class)
							.add(Restrictions.idEq(employeeId))
							.uniqueResult();
		
		if(result != null){
			session.delete(result);
		}
	}

	@Override
	public void modifyEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

	public Employee getEmployeeById(int employeeId) {
		Session session = sessionFactory.getCurrentSession();
		return (Employee)session.createCriteria(Employee.class)
				.add(Restrictions.eq("employeeId", employeeId))
				.uniqueResult();
	}
	
	public Employee getEmployeeByEmailId(String emailId) {
		Session session = sessionFactory.getCurrentSession();
		return (Employee)session.createCriteria(Employee.class)
				.add(Restrictions.eq("emailId", emailId))
				.uniqueResult();
	}
	
	public List<Employee> getEmployeesByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Employee.class)
				.add(Restrictions.eq("name", name))
				.list();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Employee.class)
				.list();
	}
}
