package com.bms.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bms.Config.dbConfig;
import com.bms.Daos.UserDao;
import com.bms.Models.User;

import  static java.lang.System.out;
public class UserTest {

private static UserDao userDaoObj;
	
	@BeforeClass
	public static void init() {
		out.println("i am init start");
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(dbConfig.class);
		userDaoObj=context.getBean(UserDao.class, "userDao");
		out.println("I m in init - end");
		
	}
	
	
	@Test
	@Ignore
	public void getProductByIdTest() {
		User uObj=userDaoObj.getUserById(1021);
		assertNotNull("User with given id doesnt exist", uObj);
		
	}
}
