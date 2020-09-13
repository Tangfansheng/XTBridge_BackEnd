package com.voyager.domain.user;


public class User {
    private String username;
    private String password;
    private Integer permission;

    public User() {
        System.out.println("无参构造");
    }

    public User(String username, String password, Integer permission) {
        System.out.println("有参构造：Integer");
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public User(String username, String password, String permission) {
        System.out.println("有参构造：String");
        this.username = username;
        this.password = password;
        this.permission = Integer.parseInt(permission);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }
}
