package com.bms.ServiceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Daos.RolesDao;
import com.bms.Models.Roles;
import com.bms.Service.RolesService;
@Service("RolesService")
@Transactional
public class RolesServiceImpl implements RolesService{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	RolesDao rolesDaoObj;
	
	public List<Roles> getAllRoles() {
		return rolesDaoObj.getAllRoles();
		
		
	}

	

}
