package com.bms.Daos;

import java.util.List;

import com.bms.Models.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int employeeId);
	

}
