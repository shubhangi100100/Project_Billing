package com.bms.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bms.Models.Employee;
import com.bms.Models.Project;
import com.bms.Models.ProjectAllocation;
import com.bms.Models.ProjectConfig;
import com.bms.Models.Roles;
import com.bms.Service.EmployeeService;
import com.bms.Service.ProjectService;
import com.bms.Service.RolesService;
import com.bms.Service.UserService;

@CrossOrigin("http://localhost:4200")
@Controller
public class AdminController {

	@Autowired 
	EmployeeService employeeServiceObj;
	@Autowired
	ProjectService projectServiceObj;
	@Autowired 
	RolesService rolesServiceObj;
	@Autowired
	UserService userServiceObj;
	
	@Autowired
	HttpSession session;
	
	
	

	@GetMapping("/getProjects")
	public ResponseEntity<?>getAllProjects(){
		List<Project> pList=projectServiceObj.getAllProjects();
		
			return new ResponseEntity<List<Project>>(pList,HttpStatus.OK);
			
		
	}
	@GetMapping("/getRoles")
	public ResponseEntity<?>getAllRoles(){
		List<Roles> rList=rolesServiceObj.getAllRoles();
		 return new ResponseEntity<List<Roles>>(rList,HttpStatus.OK);
		 
	}
	@GetMapping("/getProjConfig")
	public ResponseEntity<?>getProjectConfig(){
		List<ProjectConfig> pcList=projectServiceObj.getProjectConfig();
		return new ResponseEntity<List<ProjectConfig>>(pcList,HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmployees")
	public ResponseEntity<?>getAllEmployees(){
		List<Employee> eList=employeeServiceObj.getAllEmployees();
		return new ResponseEntity<List<Employee>>(eList,HttpStatus.OK);
		
	}
	@PostMapping("/saveConfig")
	public boolean saveConfig(@RequestBody ProjectConfig projObj) {
		projObj.setrObj(rolesServiceObj.getRoleById(projObj.getRoleId()));
		  projObj.setpObj(projectServiceObj.getProjectById(projObj.getProjectId()));
		  

		  boolean saved = projectServiceObj.getProject(projObj);
		  return saved;

		
		
	}
	
	
	@PostMapping("/saveAllocate")
	public boolean saveAllocation(@RequestBody ProjectAllocation paObj) {
		paObj.seteObj(employeeServiceObj.getEmployeeById(paObj.getEmployeeId()));
		boolean saved = projectServiceObj.setAllocation(paObj);
		return saved;
		
		
		
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
