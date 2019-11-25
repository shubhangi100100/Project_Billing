package com.bms.Service;

import java.util.List;

import com.bms.Models.Attendance;
import com.bms.Models.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int employeeId);
	
	
	
	public boolean setAttendance(Attendance Obj);
}
