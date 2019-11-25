package com.bms.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
	@Id
	@GeneratedValue
	private int attendanceId;
	
	private String month;
	private int year;
	private int halfDay;
	private int fullDay;
	
	@ManyToOne
	@JoinColumn(name="projectId", insertable=false,updatable=false)
	Project pObj;
	
	@OneToOne
	@JoinColumn(name="employeeId", insertable=false,updatable=false)
	Employee eObj;
	
	private int employeeId;
	private int projectId;
	
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHalfDay() {
		return halfDay;
	}
	public void setHalfDay(int halfDay) {
		this.halfDay = halfDay;
	}
	public int getFullDay() {
		return fullDay;
	}
	public void setFullDay(int fullDay) {
		this.fullDay = fullDay;
	}
	public Project getpObj() {
		return pObj;
	}
	public void setpObj(Project pObj) {
		this.pObj = pObj;
	}
	public Employee geteObj() {
		return eObj;
	}
	public void seteObj(Employee eObj) {
		this.eObj = eObj;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", month=" + month + ", year=" + year + ", halfDay="
				+ halfDay + ", fullDay=" + fullDay + ", pObj=" + pObj + ", eObj=" + eObj + ", employeeId=" + employeeId
				+ ", projectId=" + projectId + "]";
	}
	
	
	
	
	
	
	
	
}
