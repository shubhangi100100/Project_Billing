package com.bms.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.bms.Daos.RolesDao;
import com.bms.Models.Roles;
import com.bms.Service.RolesService;
@Component
@Repository(value="rolesDao")

public class RolesDaoImpl implements RolesDao{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	RolesService rolesServiceObject;
	
	public List<Roles> getAllRoles() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.Models.Roles");
		if(q.list()== null) {
			System.out.println("Is Null");
			return null;
		}
		else
			
			return q.list();
		
	}

	public Roles getRoleById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Roles r=session.get(Roles.class, id);
		return r;
		
		
	}

	

}
