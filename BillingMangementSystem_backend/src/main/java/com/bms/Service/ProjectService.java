package com.bms.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Models.Project;
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;

public interface ProjectService {
	
	public List<Project> getAllProjects();
	public List<ProjectConfig> getProjectConfig();
	public boolean getProject(ProjectConfig pcObj);
	public List<ProjectConfig>  validateProject(int projectId, int roleId, String location);
	public boolean setAllocation(ProjectAllocation proAllObj);
	
	
	

}
