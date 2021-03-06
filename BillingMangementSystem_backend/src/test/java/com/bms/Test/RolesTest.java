package com.bms.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bms.Config.dbConfig;
import com.bms.Daos.RolesDao;
import com.bms.Daos.UserDao;
import com.bms.Models.Roles;

public class RolesTest {

private static RolesDao rolesDaoObj;
	
	@BeforeClass
	public static void init() {
		out.println("i am init start");
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(dbConfig.class);
		rolesDaoObj=context.getBean(RolesDao.class, "rolesDao");
		out.println("I m in init - end");
		
	}
@Test
@Ignore
public void getAllRolesTest(){
	List<Roles> rlist=rolesDaoObj.getAllRoles();
	assertNotNull("User with given id doesnt exist", rlist);
}
		
}
