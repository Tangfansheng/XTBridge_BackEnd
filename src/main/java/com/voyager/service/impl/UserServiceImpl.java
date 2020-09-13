package com.voyager.service.impl;

import com.voyager.dao.user.UserDao;
import com.voyager.domain.user.LoginValidation;
import com.voyager.domain.user.User;
import com.voyager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findUser(String username) {
        User user = userDao.findUser(username);
        return user;
    }

    @Override
    public LoginValidation validateLogin(String username, String password) {
        User user = userDao.findUser(username);
        if(user == null){
            return new LoginValidation(null, 400, null);
        }else{
            if(!user.getPassword().equals(password)){
                return new LoginValidation(null, 300, null);
            }else{
                return new LoginValidation(user, 200, "thisisatoken");
            }
        }
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public int deleteUser(String username) {
        return userDao.deleteUser(username);
    }

    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }


}
