package com.restexample.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restexample.crud.dao.IUserDAO;
import com.restexample.crud.entities.Users;
import com.restexample.crud.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApipocApplicationTests {
	
	@Autowired
	private IUserService userService;
	
	
	@Test
    public void deactivateSuccess() {
    	String result=userService.deleteUser("45%6");
    	assertEquals("USER_DEACTIVATED_SUCCESSFULLY",result);
    }
	@Test
    public void UpdateSuccess() {
		Users user=new Users();
		user.setfName("Fname");
		user.setlName("Lname");
		user.setEmail("test@gmail.com");
		user.setPinCode(123456);
		user.setBirthDate(new Date());
    	String result=userService.updateUser("45%6", user);
    	assertEquals("USER_UPDATED_SUCCESSFULLY",result);
    }
}
