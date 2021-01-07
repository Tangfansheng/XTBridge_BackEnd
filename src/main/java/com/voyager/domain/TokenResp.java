package com.voyager.domain;

public class TokenResp {
    private TokenContent data;
    private String code;
    private String msg;

    public TokenResp(TokenContent data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public TokenResp() {
    }
    public void setData(TokenContent data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TokenContent getData() {
        return data;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
    @Override
    public String toString() {
        return "TokenResp{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
