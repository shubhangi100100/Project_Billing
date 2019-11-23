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
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;
import com.bms.Service.EmployeeService;
import com.bms.Service.ProjectService;
@Component
@Repository(value="projectDao")
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Project> getAllProjects() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.Project");
		if(q.list()== null) {
			System.out.println("Is Null");
			return null;
		}
		else
			
			return q.list();
		}

	
	
	
	public List<ProjectConfig> getProjectConfig() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.ProjectConfig");
		
		return q.list();
	}

	
	
	
	    public boolean getProject(ProjectConfig pcObj) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from com.bms.Models.ProjectConfig where projectId=:projectId and roleId=:roleId and location=:location");
		
		q.setParameter("projectId", pcObj.getProjectId());
		q.setParameter("roleId", pcObj.getRoleId());
		q.setParameter("location", pcObj.getLocation());
		
		if(q.list().size()==0) {
			session.save(pcObj);
			return true;
			
		}
		return false;
	}




		public List<ProjectConfig> validateProject(int projectId, int roleId, String location) {
			Session session=sessionFactory.getCurrentSession();
			Query q= session.createQuery("from com.bms.Models.ProjectConfig where pObj.projectId=:projectId and rObj.roleId=:roleId and location=:location");
			 q.setParameter("projectId",projectId);

			   q.setParameter("roleId",roleId);

			   q.setParameter("location",location);

			return q.list();

		}




		public boolean setAllocation(ProjectAllocation proAllObj) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from com.bms.Models.ProjectAllocation where employeeId=:employeeId and configId=:configId");
		
		q.setParameter("employeeId", proAllObj.geteObj());
		q.setParameter("configId", proAllObj.getPcObj());
		if(q.list().size()==0) {
			session.save(proAllObj);
			return true;
		}
		return false;
		
			
		}




		public List<ProjectConfig> getAllProjectConfig(int projectId) {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.bms.Models.ProjectConfig where pObj.projectId=:projectId");
			q.setParameter(projectId, projectId);
			return q.list();
			
		}




		public List<ProjectAllocation> getProjectAllocations() {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.bms.Models.ProjAllocation");
			
			List list=q.list();
			return list;
			
		}

	

	
	}

	


