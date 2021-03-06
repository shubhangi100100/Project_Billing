package com.bms.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ProjectAllocation")
public class ProjectAllocation {
	@Id
	@GeneratedValue
	private int allocationId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="configId")
	ProjectConfig pcObj;
	
	@OneToOne
	@JoinColumn(name="employeeId")
	Employee eObj;
	
	@Transient
	int configId;
	@Transient
	int employeeId;
	
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public ProjectConfig getPcObj() {
		return pcObj;
	}
	public void setPcObj(ProjectConfig pcObj) {
		this.pcObj = pcObj;
	}
	public Employee geteObj() {
		return eObj;
	}
	public void seteObj(Employee eObj) {
		this.eObj = eObj;
	}
	
	
	public int getConfigId() {
		return configId;
	}
	public void setConfigId(int configId) {
		this.configId = configId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "ProjectAllocation [allocationId=" + allocationId + ", pcObj=" + pcObj + ", eObj=" + eObj + ", configId="
				+ configId + ", employeeId=" + employeeId + "]";
	}
	
	

	
	
}
