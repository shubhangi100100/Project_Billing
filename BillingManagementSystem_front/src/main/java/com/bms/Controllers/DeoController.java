package com.bms.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bms.Models.Attendance;
import com.bms.Models.Employee;
import com.bms.Models.Project;
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;
import com.bms.Models.Roles;
import com.bms.Service.EmployeeService;
import com.bms.Service.ProjectService;
import com.bms.Service.RolesService;
import com.bms.Service.UserService;

@Controller
public class DeoController {
	
	@Autowired
    HttpSession session;
	
	@Autowired
	UserService userServiceObj;
	
	@Autowired
	ProjectService projectServiceObj;
	
	@Autowired
	EmployeeService employeeServiceObj;
	
	@Autowired
	RolesService rolesServiceObj;
	
	
	@RequestMapping(value="/setAtt", method=RequestMethod.GET)
	public ModelAndView enterAttendance() {
		List<Project> proj=projectServiceObj.getAllProjects();
		List<Employee> emp=employeeServiceObj.getAllEmployees();
		 
		Attendance aObj= new Attendance();
		ModelAndView mv= new ModelAndView("DataEntryPage");
		
		mv.addObject("proj", proj);
		mv.addObject("aObj", aObj);
		
		return mv;
		
		
	}
	
	@RequestMapping(value="submitAttendance", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(@RequestParam("projectId")int projectId){
		
		System.out.println("Given project id:" +projectId);
		List<Employee> empList=new ArrayList();
		
		List<ProjectConfig> pcList= projectServiceObj.getAllProjectConfig(projectId);
		List<ProjectAllocation> paList = projectServiceObj.getProjectAllocations();
		
		 for(ProjectConfig config:pcList) {
			 for(ProjectAllocation allocate:paList) {
				 if(config.getConfigId()==allocate.getPcObj().getConfigId()) {
					 
					 
					 Employee empObj=allocate.geteObj();
					 empList.add(empObj);
				 }
			 }
		 }
		 System.out.println("empList : "+empList);
		 
		 return empList;
		
	}

}
