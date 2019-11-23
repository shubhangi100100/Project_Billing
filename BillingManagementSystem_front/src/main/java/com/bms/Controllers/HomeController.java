package com.bms.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.Daos.UserDao;
import com.bms.Models.User;

@Controller
public class HomeController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String sayHello() {
		return "HomePage";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String enter() {
		
		return "Login";
		
	}
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="OpenPage", method=RequestMethod.POST)
	public String validateUser(@RequestParam int userid, @RequestParam String password) {
		User uObj= userDao.validateUser(userid, password);
		
	if (uObj==null) {
		
		return "Login";
		
	}
	else {
		String role=uObj.getRole();
		session.setAttribute("uObj",uObj);
		if(role.equals("Admin"))
		{
			return "AdminPage";
			
		}
		else
			if(role.equals("Data Entry Operator")) {
			return "DataEntryPage";
		
	} 
			else
				 return "ManagerPage";
		 
	}
			
	
	}
}

