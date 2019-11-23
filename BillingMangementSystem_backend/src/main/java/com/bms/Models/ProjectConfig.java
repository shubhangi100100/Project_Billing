package com.bms.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ConfigTable")
public class ProjectConfig {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int configId;
	
	private String location;
	
	@ManyToOne
	@JoinColumn(name="projectId", insertable=false, updatable=false)
	private Project pObj;
	
	@Column(name="perhourbill")
	private int perHourBilling;
	
	@ManyToOne
	@JoinColumn(name="roleId", insertable=false, updatable=false)
	private  Roles rObj;
	
	@Column(name="projectId")
	private int projectId;
	
	@Column(name="roleId")
	private int roleId;

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

	public Project getpObj() {
		return pObj;
	}

	public void setpObj(Project pObj) {
		this.pObj = pObj;
	}

	public int getPerHourBilling() {
		return perHourBilling;
	}

	public void setPerHourBilling(int perHourBilling) {
		this.perHourBilling = perHourBilling;
	}

	public Roles getrObj() {
		return rObj;
	}

	public void setrObj(Roles rObj) {
		this.rObj = rObj;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "ProjectConfig [configId=" + configId + ", location=" + location + ", pObj=" + pObj + ", perHourBilling="
				+ perHourBilling + ", rObj=" + rObj + ", projectId=" + projectId + ", roleId=" + roleId + "]";
	}


	
	
	
	}
	
	


