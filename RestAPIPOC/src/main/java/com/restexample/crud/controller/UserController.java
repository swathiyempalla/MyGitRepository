package com.restexample.crud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.restexample.crud.entities.Users;
import com.restexample.crud.service.IUserService;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/showallusers")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> list = userService.getAllUsers();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> createUser(@RequestBody Users user, UriComponentsBuilder builder) {
        boolean flag = userService.addUser(user);
        if (flag == false) {
        	String message="An active User already exists with same email";
        	return new ResponseEntity<String>(message,HttpStatus.CONFLICT);
        }
        String userid=userService.createUser(user);
        String message="User with "+userid+" created successfully";
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PatchMapping("/updateuser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") String id,@RequestBody Users user) {
		userService.updateUser(id, user);
		String message="user updated successfully";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 