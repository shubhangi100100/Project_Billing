package com.bms.Controllers;

import java.util.List;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bms.Daos.EmployeeDao;
import com.bms.Daos.ProjectDao;
import com.bms.Daos.RolesDao;
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
public class AdminController {

	@Autowired
	ProjectService projectServiceObj;
	@Autowired 
	RolesService rolesServiceObj;
	@Autowired
	UserService userServiceObj;
	@Autowired 
	EmployeeService employeeServiceObj;
	
	
	
	@RequestMapping(value="/getConfig",method=RequestMethod.GET)
	public ModelAndView getLists() {
	List<Project> proj=projectServiceObj.getAllProjects();
	List<Roles> roles= rolesServiceObj.getAllRoles();
	
	System.out.println("Project List : "+proj);
	System.out.println("Role List : "+roles);
	
	ModelAndView mv= new ModelAndView("ProjConfig");
	
	mv.addObject("proj", proj);
	mv.addObject("roles", roles);
	mv.addObject("pObj",new ProjectConfig());
	
	return mv;
	
	}

	@RequestMapping(value="/saveConfig", method=RequestMethod.POST)
	public ModelAndView makeConfig(@ModelAttribute(name="pObj") ProjectConfig pcObj) {
		System.out.println(pcObj);
		
		boolean saved= projectServiceObj.getProject(pcObj);
		System.out.println("saved" +saved);
		
		List<Project> proj=projectServiceObj.getAllProjects();
		List<Roles> roles= rolesServiceObj.getAllRoles();
		List<ProjectConfig> pConfig= projectServiceObj.getProjectConfig();
		
		
		ModelAndView mv= new ModelAndView("ConfigSaved");
		mv.addObject("proj", proj);
		System.out.println(proj);
		mv.addObject("roles", roles);
		mv.addObject("pConfig", pConfig);
		mv.addObject("pcObj",new ProjectConfig());
		
		if(saved) {
			mv.addObject("msg","completed");
			return mv;
			
		}
		else
		{
		mv.addObject("msg", "error");
		return mv;
		
		}
		
	}
	@RequestMapping(value="/getAllocation", method=RequestMethod.GET)
	public ModelAndView allocateProject(@ModelAttribute(name="pObj") ProjectConfig pcObj) {
	

		List<Project> proj=projectServiceObj.getAllProjects();
		List<Roles> roles= rolesServiceObj.getAllRoles();
		List<Employee> emp=employeeServiceObj.getAllEmployees();
		
		ModelAndView mv= new ModelAndView("ProjAllocation");
		
		mv.addObject("proj", proj);
		mv.addObject("roles", roles);
		mv.addObject("emp", emp);
	
		
		return mv;
		
			 
}
	
	
	
	@RequestMapping(value="/submitAllocation", method=RequestMethod.GET)
	public String setAllocation(@RequestParam int projectId, @RequestParam int roleId,@RequestParam String location,@RequestParam int employeeId, ModelMap map) {
		// to show the id on console
		System.out.println(projectId+""+roleId+""+location+""+employeeId);
		List<Project> proj=projectServiceObj.getAllProjects();
		List<Roles> roles= rolesServiceObj.getAllRoles();
		List<Employee> emp=employeeServiceObj.getAllEmployees();
		
	    map.addAttribute("proj", proj);
		map.addAttribute("roles", roles);
		map.addAttribute("emp", emp);
	
		List <ProjectConfig> obj= projectServiceObj.validateProject(projectId,roleId,location);
		ProjectConfig pc= obj.get(0);
		
		Employee empObj= employeeServiceObj.getEmployeeById(employeeId);
		
		ProjectAllocation pa= new ProjectAllocation();
		
	   pa.setPcObj(pc);
	   pa.seteObj(empObj);
		
		
	   boolean saved=projectServiceObj.setAllocation(pa);
		if(saved) {
			map.addAttribute("msg","Allocation completed");
			return "AllocateDone";
			
		}
		else {
			map.addAttribute("msg","Allocation could not be processed");
		return "AllocateDone";
		}

		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}