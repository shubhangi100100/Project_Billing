package com.bms.Daos;

import org.springframework.transaction.annotation.Transactional;

import com.bms.Models.User;
@Transactional
public interface UserDao {

		public User getUserById(int uid);
		public User validateUser(int uid, String password);
		
	
}
