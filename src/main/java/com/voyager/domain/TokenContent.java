package com.voyager.domain;

public class TokenContent {
    private String accessToken;
    private String expireTime;

    public TokenContent(String accessToken, String expireTime) {
        this.accessToken = accessToken;
        this.expireTime = expireTime;
    }

    public TokenContent() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "TokenContent{" +
                "accessToken='" + accessToken + '\'' +
                ", expireTime='" + expireTime + '\'' +
                '}';
    }
}
