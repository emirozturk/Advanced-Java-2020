package com.emirozturk.Dao;

import com.emirozturk.Entity.User;

import java.util.List;

public interface IUserDao {
    User addUser(User user);
    User deleteUser(User user);
    User updateUser(User user);
    List<User> getUsers();
    User getUserbyUserName(String name);
    User getUserbyUserbyId(int id);
}
