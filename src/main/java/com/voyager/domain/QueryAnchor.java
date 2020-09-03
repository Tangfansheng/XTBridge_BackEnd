package com.voyager.domain;


import java.util.*;

public class QueryAnchor {
    private Float force1;
    private Float force2;
    private Float force3;
    private Float force4;
    private Float force5;
    private Float force6;

    private Date datetime;

    public QueryAnchor(Float force1, Float force2, Float force3, Float force4, Float force5, Float force6, Date datetime) {
        this.force1 = force1;
        this.force2 = force2;
        this.force3 = force3;
        this.force4 = force4;
        this.force5 = force5;
        this.force6 = force6;
        this.datetime = datetime;
    }

    public List<Float> getForces(){
        List<Float> res = new ArrayList<>();
        res.add(force1);
        res.add(force2);
        res.add(force3);
        res.add(force4);
        res.add(force5);
        res.add(force6);
        return res;
    }

    @Override
    public String toString() {
        return "QueryAnchor{" +
                "force1=" + force1 +
                ", force2=" + force2 +
                ", force3=" + force3 +
                ", force4=" + force4 +
                ", force5=" + force5 +
                ", force6=" + force6 +
                ", date=" + datetime +
                '}';
    }
}
