package com.bms.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.Daos.UserDao;
import com.bms.Models.User;
import com.bms.Service.EmployeeService;
import com.bms.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserDao userDao;
	@Autowired
	UserService userServiceObj;
	@Autowired
	EmployeeService employeeServiceObj;
	
	
	
	@Autowired
	HttpSession session;
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String sayHello() {
		return "HomePage";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String enter() {
		
		return "Login";
		
	}
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String exit(ModelMap map) {
		session.invalidate();
		map.addAttribute("txt", "you have been logged out");
		
		return "LogOut";
		
	}
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String homePage() {
	
				return "HomePage";
			
	}
	
	@RequestMapping(value="Adminhome", method=RequestMethod.GET)
	public String AdminHome() {
		return "AdminPage";
	}
	
	
	@RequestMapping(value="DEhome", method=RequestMethod.GET)
	public String DEHome() {
		return "DataEntryPage";
	}
	
	
	@RequestMapping(value="OpenPage", method=RequestMethod.POST)
	public String validateUser(@RequestParam int userid, @RequestParam String password, ModelMap map) {
		User user= userDao.validateUser(userid, password);
		
	if (user==null) {
		map.addAttribute("msg", "userId or Password incorrect, please check it.");
		
		return "Login";
		
	}
	else {
		String role=user.getRole();
		session.setAttribute("user",user);
		if(role.equals("Admin"))
		{
			map.addAttribute("user", user);
			
			return "AdminPage";
			
		}
		else
			if(role.equals("Data Entry Operator")) {
				
				map.addAttribute("user", user);
			return "DataEntryPage";
		
	} 
			else
				map.addAttribute("user", user);
				 return "ManagerPage";
		 
	}
			
	
	}
	@RequestMapping(value="aboutUs", method=RequestMethod.GET)
	public String aboutUs() {
		return "AboutUs";
	
}
	
	
	
	@RequestMapping(value="contactUs", method=RequestMethod.GET)
	public String contactUs() {
		return "ContactUs";
	
}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


