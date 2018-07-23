package com.restexample.crud.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restexample.crud.entities.Users;
import com.restexample.crud.exceptions.UserNotFoundException;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

	@Override
	public String addUser(Users user) {
   
	
    	Users userobj=new Users();
		userobj.setId(user.getId());
		userobj.setfName(user.getfName());
		userobj.setlName(user.getlName());
		userobj.setEmail(user.getEmail());
		userobj.setPinCode(user.getPinCode());
		userobj.setActive(true);
		userobj.setBirthDate(user.getBirthDate());
		entityManager.persist(userobj);	
		return userobj.getId();
	
	
	}

	@Override
	public void updateUser(String id,Users user) {
		Users user1 = entityManager.find(Users.class,id);
		if(user1==null) {
			String message="Unable to update. User with "+id+"not found";
			logger.error("Unable to update.User not found.", user.getId());
			throw new UserNotFoundException(id,message);
		}
		user1.setPinCode(user.getPinCode());
		user1.setBirthDate(user.getBirthDate());
		entityManager.flush();
		
	}

	@Override
	public void deleteUser(String userId) {
		Users userobj=entityManager.find(Users.class, userId);
		if(userobj==null) {
			
			 String message="Unable to delete.User with id "+userId+" not found";
			 logger.error("Unable to delete. User not found.",userId);
			throw new UserNotFoundException(userId,message);
		}
		userobj.setActive(false);
		entityManager.persist(userobj);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		String hql="from Users";
		return (List<Users>) entityManager.createQuery(hql).getResultList();

	}

	@Override
	public boolean CheckIfUserExists(Users user) {
		int count=0;
		List<Users> userList=getAllUsers();
		for(Users user1:userList) {
			if(user1.isActive() && user1.getEmail().equalsIgnoreCase(user.getEmail())) {
				System.out.println("An active user with same email id exists already");
				++count;
			}
		}
			return count>0?true:false;
	}	
	
	}
