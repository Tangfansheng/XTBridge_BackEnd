package com.voyager.domain.user;

public class LoginValidation {
    private User user;
    private int code;//code:200表示登录成功 300表示密码错误 400表示无此账号
    private String token;//令牌

    public LoginValidation(User user, int code, String token) {
        this.user = user;
        this.code = code;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LoginValidation{" +
                "user=" + user +
                ", code=" + code +
                ", token='" + token + '\'' +
                '}';
    }
}
