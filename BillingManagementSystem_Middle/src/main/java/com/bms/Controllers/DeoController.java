package com.bms.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Models.Attendance;
import com.bms.Models.Employee;
import com.bms.Models.Project;
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;
import com.bms.Service.EmployeeService;
import com.bms.Service.ProjectService;
import com.bms.Service.RolesService;
import com.bms.Service.UserService;

@RestController
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
	
	
	

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employeeDetails")
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
	
	@CrossOrigin(origins="http://localhost:4200")
	 @ResponseBody
	 @RequestMapping(value="/saveAttendance",method=RequestMethod.POST)
	 public ResponseEntity<?> submitAttendance(@RequestBody Attendance dataObj){
	   
	   Employee eObj=employeeServiceObj.getEmployeeById(dataObj.getEmployeeId());
	   Project pObj=projectServiceObj.getProjectById(dataObj.getProjectId());
	   dataObj.seteObj(eObj);
	   dataObj.setpObj(pObj);
	   boolean saved=employeeServiceObj.setAttendance(dataObj);
	   if(saved) {
	   return new ResponseEntity<String>("done",HttpStatus.OK);
	    
	   }
	   else {
	    return new ResponseEntity<String>("cannot be done",HttpStatus.OK);
	   
	  }
	   
	 }

	
	

	 /*
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/saveAttendance")
	public boolean saveAttendance(@RequestBody Attendance attObj,@RequestParam int projectId, @RequestParam int employeeId) {
		List<Project> proj=projectServiceObj.getAllProjects();
		System.out.println(projectId);
		
		
		Employee empObj= employeeServiceObj.getEmployeeById(employeeId);
		Project projObj= projectServiceObj.getProjectById(projectId);
		 
		attObj.seteObj(empObj);
		attObj.setpObj(projObj);
		boolean saved= employeeServiceObj.setAttendance(attObj);
		if(saved) {
			System.out.println("saved");
			
			return true;
			
		}
		else
		{
			System.out.println("not saved");
			return false;
			
			
		}
		
		
	}
	*/
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


