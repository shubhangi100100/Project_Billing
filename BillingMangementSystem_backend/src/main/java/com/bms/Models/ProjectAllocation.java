package com.bms.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProjectAllocation")
public class ProjectAllocation {
	@Id
	@GeneratedValue
	private int allocationId;
	@ManyToOne
	@JoinColumn(name="configId")
	ProjectConfig pcObj;
	
	@ManyToOne
	@JoinColumn(name="employeeId")
	Employee eObj;
	
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
	@Override
	public String toString() {
		return "ProjectAllocation [allocationId=" + allocationId + ", pcObj=" + pcObj + ", eObj=" + eObj + "]";
	}

	
	
}
