package com.bms.ServiceImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Daos.EmployeeDao;
import com.bms.Models.Attendance;
import com.bms.Models.Employee;
import com.bms.Service.EmployeeService;


@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	EmployeeDao employeeDaoObj;
	
	public List<Employee> getAllEmployees() {
	
		return employeeDaoObj.getAllEmployees();
	}

	public Employee getEmployeeById(int employeeId) {
		
		return employeeDaoObj.getEmployeeById(employeeId);
	}

	public boolean setAttendance(Attendance Obj) {
		
		return employeeDaoObj.setAttendance(Obj);
	}

	public List<Attendance> getAllAttendance() {
		
		return employeeDaoObj.getAllAttendance();
	}

	public Attendance setBill(int id, String month, int year) {
		
		return employeeDaoObj.setBill(id, month, year);
	}

	public double getBill(double perhourbill, Attendance aObj) {
		
		return employeeDaoObj.getBill(perhourbill, aObj);
	}

	public String getEmpById(int id) {
		
		return employeeDaoObj.getEmpById(id);
	}

	
}
