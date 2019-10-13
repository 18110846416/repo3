package com.xiong.service;

import com.xiong.dao.UserDao;
import com.xiong.pojo.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
