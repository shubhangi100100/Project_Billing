package com.bms.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.Daos.EmployeeDao;
import com.bms.Models.Attendance;
import com.bms.Models.Employee;
import com.bms.Service.EmployeeService;
@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Employee> getAllEmployees() {
	
		Session session= sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.Employee");
		if(q.list()== null) {
			System.out.println("null");
			
			return null;
			
		}
		else
			return q.list();
		
	}

	public Employee getEmployeeById(int employeeId) {
		Session session=sessionFactory.getCurrentSession();
		Employee e= session.get(Employee.class, employeeId);
		
		return e;
	}

	public boolean  setAttendance(Attendance Obj) {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.Attendance where projectId=:projectId and employeeId=:employeeId");
		q.setParameter("employeeId", Obj.getEmployeeId() );
		q.setParameter("projectId", Obj.getProjectId());
		
		if(q.list().size()==0) {
			session.save(Obj);
			return true;
			
		}
		else
			return false;
		
	}

	
	

	
	
	

}
