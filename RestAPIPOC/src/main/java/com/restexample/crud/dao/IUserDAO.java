package com.restexample.crud.dao;
import java.util.List;

import com.restexample.crud.entities.Users;
public interface IUserDAO {

    List<Users> getAllUsers();
    public String addUser(Users user);
    void updateUser(String id,Users user);
    void deleteUser(String userId);
    public  boolean CheckIfUserExists(Users user);
}
 