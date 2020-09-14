package com.voyager.controller.user;

import com.voyager.domain.user.LoginValidation;
import com.voyager.domain.user.User;
import com.voyager.domain.wrapper.WrapperData;
import com.voyager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;

    /**
     * post登录请求
     * 请求参数中只有一个username
     */
    @ResponseBody
    @CrossOrigin
    @RequestMapping("check")
    public Object check(String username) {
        User user = userService.findUser(username);
        return user;
    }


    @ResponseBody
    @CrossOrigin
    @RequestMapping("login")
    public Object checkLogin(String username, String password){
        System.out.println("input params : " +username +" "+password);
        LoginValidation loginValidation = userService.validateLogin(username, password);
        return loginValidation;
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping("users")
    public Object getUsers(){
        List<User> users = userService.getUsers();
        if(users == null ||users.size() == 0){
            return new WrapperData(null, 300);
        }
        return new WrapperData(users, 200);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping("users")
    public Object addUser(@RequestBody User user){
        System.out.println(user);
        int row = userService.addUser(user);
        System.out.println(row);
        if(row<0){
            return new WrapperData(null, 300);
        }
        return new WrapperData(user, 200);
    }

    @CrossOrigin
    @ResponseBody
    @DeleteMapping("users")
    public Object deleteUser(String username){
        int row = userService.deleteUser(username);
        if(row==0){
            return new WrapperData(null, 300);
        }
        return new WrapperData(null, 200);
    }


    @CrossOrigin
    @ResponseBody
    @PutMapping("users")
    public Object editUser(@RequestBody User user){
        int row = userService.editUser(user);
        if(row==0){
            return new WrapperData(null, 300);
        }
        return new WrapperData(user, 200);
    }
}
