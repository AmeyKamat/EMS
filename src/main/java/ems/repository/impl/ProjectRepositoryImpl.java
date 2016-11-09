package ems.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ems.entity.Department;
import ems.entity.Project;
import ems.repository.ProjectRepository;

@Repository
@Transactional
public class ProjectRepositoryImpl implements ProjectRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Project> getAllProjects() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Project.class).list();
	}
	
	@Override
	public Project getProjectById(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		return (Project)session.createCriteria(Project.class)
				.add(Restrictions.eq("projectId", projectId))
				.uniqueResult();
	}
	
	@Override
	public List<Project> getProjectsByDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Project.class)
				.add(Restrictions.eq("department", department))
				.list();
	}
	
	
}
