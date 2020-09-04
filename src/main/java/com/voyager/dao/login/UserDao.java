package com.voyager.dao.login;

import com.voyager.domain.login.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    @Select("select username, password, permission from user where username = #{username}")
    public User findUser(String username);

    @Insert("insert into user (username, password, permission) values (#{username, jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{permission, jdbcType=INTEGER})")
    public int addUser(User user);


    @Select("select username, password, permission from user")
    public List<User> getUsers();
}
