package com.bms.Service;

import org.springframework.transaction.annotation.Transactional;

import com.bms.Models.User;
@Transactional
public interface UserService {

		public User getUserById(int uid);
		public User validateUser(int uid, String password);
		
	
}
