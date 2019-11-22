package com.bms.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bms.Models.Project;

public interface ProjectService {
	
	public List<Project> getAllProjects();
	
	
	
	

}
