package com.restexample.crud.service;

import java.util.List;

import com.restexample.crud.entities.Users;

public interface IUserService {
     List<Users> getAllUsers();
     boolean addUser(Users user);
     void updateUser(String id,Users user);
     void deleteUser(String userId);
     public String createUser(Users user);
}
