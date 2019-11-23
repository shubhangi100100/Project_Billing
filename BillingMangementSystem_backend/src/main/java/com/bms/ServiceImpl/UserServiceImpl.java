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
	@Autowired
	UserDao userDaoObj;
	
	
	public User getUserById(int uid) {
		return userDaoObj.getUserById(uid);
		
	}

	public User validateUser(int uid, String password) {
		return userDaoObj.validateUser(uid, password);
		
		
	}
	

	
}
