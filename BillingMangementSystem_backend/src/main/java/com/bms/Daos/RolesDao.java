package com.bms.Daos;

import java.util.List;

import com.bms.Models.Roles;

public interface RolesDao {

	public List<Roles> getAllRoles();
	public Roles getRoleById(int id);
	

}
