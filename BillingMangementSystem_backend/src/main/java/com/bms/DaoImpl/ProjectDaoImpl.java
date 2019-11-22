package com.bms.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.bms.Daos.ProjectDao;
import com.bms.Models.Project;
@Component
@Repository(value="projectDao")
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Project> getAllProjects() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.models.Project");
		if(q.list()== null) {
			System.out.println("Is Null");
			return null;
		}
		else
			
			return q.list();
		
		
	}

	

}
