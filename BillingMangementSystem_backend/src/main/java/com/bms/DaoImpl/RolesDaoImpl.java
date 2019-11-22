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
@Component
@Repository(value="rolesDao")

public class RolesDaoImpl implements RolesDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Roles> getAllRoles() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from com.bms.models.Roles");
		if(q.list()== null) {
			System.out.println("Is Null");
			return null;
		}
		else
			
			return q.list();
		
	}

	

}
