package com.bms.Controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bms.Models.Employee;
import com.bms.Models.User;
import com.bms.Service.EmployeeService;
import com.bms.Service.UserService;

@CrossOrigin("http://localhost:4200")
@Controller
public class HomeController {

	@Autowired 
	EmployeeService employeeServiceObj;
	
	
	@Autowired
	HttpSession session;
	 
	@Autowired
	UserService userServiceObj;
	

	@PostMapping("/validateUser")
	public ResponseEntity<?>validateUser(@RequestParam int userId,@RequestParam String password){
		User uObj= userServiceObj.validateUser(userId, password);
		if(uObj==null){
			return new ResponseEntity<String>("invalid login", HttpStatus.OK);
			
		}
		else
		{
			session.setAttribute("userObj", uObj);
			return new ResponseEntity<String>(uObj.getRole(), HttpStatus.OK);
			
		}
		
	}
	
	
	@GetMapping("/exit")
	public ResponseEntity<?>exit(){
		session.invalidate();
		return new ResponseEntity<String>("You have been logged out, session is invalid", HttpStatus.OK);
		
	}
	
	
	

}
