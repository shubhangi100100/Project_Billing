package com.bms.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bms.Daos.UserDao;
import com.bms.Models.User;
@Repository("userDao")
@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private	SessionFactory sessionFactory;
	
	
	public User getUserById(int uid) {
		Session session= sessionFactory.getCurrentSession();
		User user= session.get(User.class, uid);
		return user;
	}

	public User validateUser(int uid, String password) {
		Session session= sessionFactory.getCurrentSession();
		User uObj= session.get(User.class, uid);
		if(uObj!= null) {
			if(uObj.getPassword().equals(password))
		
	 return uObj;
			
	}
		return null;
		
	}
	

	
}
