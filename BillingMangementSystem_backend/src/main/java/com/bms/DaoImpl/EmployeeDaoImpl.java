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
		Query q= session.createQuery("from com.bms.Models.Attendance where employeeId=:employeeId and month=:month and year=:year");
		q.setParameter("employeeId", Obj.getEmployeeId() );
		q.setParameter("month", Obj.getMonth());
		q.setParameter("year", Obj.getYear());
		
		if(q.list().size()==0) {
			session.save(Obj);
			return true;
			
		}
		else
			return false;
		
	}

	public List<Attendance> getAllAttendance() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.Attendance");
		return q.list();
	}

	public Attendance setBill(int id, String month, int year) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from com.bms.Models.Attendance where eObj.employeeId=:id and month=:mnth and year=:yr");
		q.setParameter("id",id);

		q.setParameter("mnth",month);

		q.setParameter("yr",year);
		
		List<Attendance> aList=q.list();
		if(aList.size()!=0) {

			System.out.println("obj");

			return aList.get(0);

		}

		return null;
		
	}

	public double getBill(double perhourbill, Attendance aObj) {
		double halfDay=aObj.getHalfDay()*4.5;

		double fullDay=aObj.getFullDay()*9;

		double bill=((halfDay*perhourbill)+(fullDay*perhourbill));

		return bill;
	}

	
	
	public String getEmpById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Employee obj = session.get(Employee.class, id);

		String nameOfEmployee = obj.getEmployeeName();
		return nameOfEmployee;
	}
	}

	
	

	
	
	


