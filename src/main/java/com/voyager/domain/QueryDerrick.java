package com.voyager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.*;

public class QueryDerrick {
    private Float force1;
    private Float force2;
    private Float force3;
    private Float force4;
    private Float force5;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date datetime;

    public QueryDerrick(Float force1, Float force2, Float force3, Float force4, Float force5, Date datetime) {
        this.force1 = force1;
        this.force2 = force2;
        this.force3 = force3;
        this.force4 = force4;
        this.force5 = force5;
        this.datetime = datetime;
    }


    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public List<Float> getForces() {
        List<Float> res = new ArrayList<>();
        res.add(force1);
        res.add(force2);
        res.add(force3);
        res.add(force4);
        res.add(force5);
        return res;
    }

    public Map<String, Object> getForcesMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("force1", force1);
        map.put("force2", force2);
        map.put("force3", force3);
        map.put("force4", force4);
        map.put("force5", force5);
        map.put("datetime", datetime);
        return map;
    }

    @Override
    public String toString() {
        return "QueryDerrick{" +
                "force1=" + force1 +
                ", force2=" + force2 +
                ", force3=" + force3 +
                ", force4=" + force4 +
                ", force5=" + force5 +
                ", datetime=" + datetime +
                '}';
    }
}
