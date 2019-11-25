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
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;
import com.bms.Service.ProjectService;

@Service("ProjectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectDao projectDaoObj;
	
	public List<Project> getAllProjects() {
		return projectDaoObj.getAllProjects();
		
		
		
	}

	public List<ProjectConfig> getProjectConfig() {
		return projectDaoObj.getProjectConfig();
		
	}

	public boolean getProject(ProjectConfig pcObj) {
		
		return projectDaoObj.getProject(pcObj);
	}

	public List<ProjectConfig> validateProject(int projectId, int roleId, String location) {
		
		return projectDaoObj.validateProject(projectId, roleId, location);
		
	}

	public boolean setAllocation(ProjectAllocation proAllObj) {
	
		return projectDaoObj.setAllocation(proAllObj);
		
	}

	public List<ProjectConfig> getAllProjectConfig(int projectId) {
		 return projectDaoObj.getAllProjectConfig(projectId);
		 
	}

	public List<ProjectAllocation> getProjectAllocations() {
		
	return	projectDaoObj.getProjectAllocations();
		
	}

	public Project getProjectById(int projectId) {
	
		return projectDaoObj.getProjectById(projectId);
	}

	
	
}
