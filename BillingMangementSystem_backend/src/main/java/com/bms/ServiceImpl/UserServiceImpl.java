package com.bms.ServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bms.Daos.UserDao;
import com.bms.Models.User;
import com.bms.Service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
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
