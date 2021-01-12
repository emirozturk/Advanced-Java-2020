package com.emirozturk.Service;

import com.emirozturk.Dao.IUserDao;
import com.emirozturk.Entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements IUserService{
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    @Transactional
    public User deleteUser(int id) {
        User user = userDao.getUserbyUserbyId(id);
        return userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUserbyUserName(String name) {
        return userDao.getUserbyUserName(name);
    }
}
