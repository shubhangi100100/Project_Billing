package com.bms.ServiceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Daos.ProjectDao;
import com.bms.Models.Project;
import com.bms.Service.ProjectService;
@Service("ProjectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{
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
