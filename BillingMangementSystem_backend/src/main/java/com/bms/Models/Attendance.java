package com.bms.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
	@Id
	private int attendanceId;
	
	private int month;
	private int year;
	private int halfDay;
	private int fullDay;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	Project pObj;
	
	@OneToOne
	@JoinColumn(name="employeeId")
	Employee eObj;
	
	
	
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
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
	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", month=" + month + ", year=" + year + ", halfDay="
				+ halfDay + ", fullDay=" + fullDay + ", pObj=" + pObj + ", eObj=" + eObj + "]";
	}
	
	
	
	
}
