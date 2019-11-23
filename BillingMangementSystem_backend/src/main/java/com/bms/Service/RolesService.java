package com.bms.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bms.Models.Roles;
@Transactional
public interface RolesService {

	public List<Roles> getAllRoles();

}
