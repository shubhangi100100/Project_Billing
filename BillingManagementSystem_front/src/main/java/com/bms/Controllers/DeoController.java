package com.bms.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	

	public boolean sessionHandler(ModelMap map) {
		if (session.getAttribute("user")== null){
	map.addAttribute("msg", "non existent session");
	return true;
	
	}
		else
			return false;
	}
	
	@RequestMapping(value="/setAtt", method=RequestMethod.GET)
	public ModelAndView enterAttendance(ModelMap map) {
		
		if(sessionHandler(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			
		}
		List<Project> proj=projectServiceObj.getAllProjects();
		//List<Employee> emp=employeeServiceObj.getAllEmployees();
		 
		Attendance aObj= new Attendance();
		ModelAndView mv= new ModelAndView("AttendancePage");
		
		mv.addObject("proj", proj);
		mv.addObject("aObj", aObj);
		
		return mv;
		
		
	}
	@ResponseBody
	@RequestMapping(value="/employeeDetails", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(@RequestParam("projectId") int projectId){
		
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

	
	@RequestMapping(value="/saveEnteredAttendance", method=RequestMethod.GET)
	public ModelAndView saveAttendance(@ModelAttribute(name="aObj") Attendance aObj, @RequestParam int projectId, @RequestParam int employeeId, ModelMap map){
		if(sessionHandler(map)) {
			ModelAndView mv=new ModelAndView("Login");
			return mv;
			
		}
		
		
		
		List<Project> proj=projectServiceObj.getAllProjects();
		System.out.println(projectId);
		
		List<Employee> emp=employeeServiceObj.getAllEmployees();
		ModelAndView mv= new ModelAndView("AttendanceSaved");
		  mv.addObject("proj", proj);
		  mv.addObject("emp", emp);
			
		Employee empObj= employeeServiceObj.getEmployeeById(employeeId);
		Project projObj= projectServiceObj.getProjectById(projectId);
		 
		aObj.seteObj(empObj);
		aObj.setpObj(projObj);
		
		boolean saved= employeeServiceObj.setAttendance(aObj);
		
	if(saved) {
		mv.addObject("text", "you have successfully saved the attendance");
		return mv;
		
	}
	else
	{
		mv.addObject("text", "you cannot mark attendance");
		return mv;
		
	}
		
		
	}

}
