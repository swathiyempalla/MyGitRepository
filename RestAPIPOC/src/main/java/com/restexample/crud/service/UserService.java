package com.restexample.crud.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restexample.crud.dao.IUserDAO;
import com.restexample.crud.entities.Users;
import com.restexample.crud.exceptions.UserNotFoundException;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) userDAO.getAllUsers();
	}

	@Override
	public boolean addUser(Users user) {
		if (userDAO.CheckIfUserExists(user)) {
	    	   return false;
	       } 
		else 
			return true;
	}

	@Override
	public void deleteUser(String userId) {
		userDAO.deleteUser(userId);
		
	}

	@Override
	public String createUser(Users user) {
	
		Date today=new Date();
		if(user.getBirthDate().after(today)) {
			String message = "Invalid date.Date should not be future date";
    		logger.error("Invalid date.Date should not be future date");
    	    throw new UserNotFoundException(user.getId(),message);

		}
			String	id=userDAO.addUser(user);
			return id;	
	}
	@Override
	public void updateUser(String id, Users user) {
		userDAO.updateUser(id, user);
	}	
	
}
