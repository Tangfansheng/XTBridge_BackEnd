package com.voyager.service;

import com.voyager.domain.user.LoginValidation;
import com.voyager.domain.user.User;

import java.util.List;

public interface UserService {

    public User findUser(String username);

    public LoginValidation validateLogin(String username, String password);

    public int addUser(User user);

    public List<User> getUsers();

    public int deleteUser(String username);

    public int editUser(User user);
}
