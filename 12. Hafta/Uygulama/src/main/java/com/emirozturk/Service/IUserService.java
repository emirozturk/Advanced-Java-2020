package com.emirozturk.Service;

import com.emirozturk.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    User deleteUser(int id);
    User updateUser(User user);
    List<User> getUsers();
    User getUserbyUserName(String name);
    User getUserByMail(String s);
}
