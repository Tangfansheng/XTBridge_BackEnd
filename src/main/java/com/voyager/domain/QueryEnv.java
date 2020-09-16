package com.voyager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QueryEnv {
    private String hum;
    private int wind;
    private float tem;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date datetime;

    public QueryEnv(String hum, int wind, float tem, Date datetime) {
        this.hum = hum;
        this.wind = wind;
        this.tem = tem;
        this.datetime = datetime;
    }

    public QueryEnv() {
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    @Override
    public String toString() {
        return "QueryEnv{" +
                "hum='" + hum + '\'' +
                ", wind=" + wind +
                ", tem=" + tem +
                ", datetime=" + datetime +
                '}';
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public float getTem() {
        return tem;
    }

    public void setTem(float tem) {
        this.tem = tem;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
