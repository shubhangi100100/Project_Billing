package com.bms.Daos;

import java.util.List;

import com.bms.Models.Project;
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;

public interface ProjectDao {

	public List<Project> getAllProjects();
	public List<ProjectConfig> getProjectConfig();
	public boolean getProject(ProjectConfig pcObj);
	public List<ProjectConfig>  validateProject(int projectId, int roleId, String location);
	public boolean setAllocation(ProjectAllocation proAllObj);
	
	
	
	
	

}
