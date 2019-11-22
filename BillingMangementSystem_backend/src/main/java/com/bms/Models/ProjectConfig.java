package com.bms.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ConfigTable")
public class ProjectConfig {
	@Id
	@GeneratedValue
	private int configId;
	private String location;
	@ManyToOne
	@JoinColumn(name="projectId")
	Project pObj;
	
	@Column(name="perhourbill")
	private int perHourBilling;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	Roles rObj;
	
	
	public int getConfigId() {
		return configId;
	}
	public void setConfigId(int configId) {
		this.configId = configId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getPerHourBilling() {
		return perHourBilling;
	}
	public void setPerHourBilling(int perHourBilling) {
		this.perHourBilling = perHourBilling;
	}
	public Project getpObj() {
		return pObj;
	}
	public void setpObj(Project pObj) {
		this.pObj = pObj;
	}
	public Roles getrObj() {
		return rObj;
	}
	public void setrObj(Roles rObj) {
		this.rObj = rObj;
	}
	@Override
	public String toString() {
		return "ProjectConfig [configId=" + configId + ", location=" + location + ", pObj=" + pObj + ", perHourBilling="
				+ perHourBilling + ", rObj=" + rObj + "]";
	}

	
	}
	
	


