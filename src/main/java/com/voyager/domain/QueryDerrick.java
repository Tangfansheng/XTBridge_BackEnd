package com.voyager.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryDerrick {
    private Float force1;
    private Float force2;
    private Float force3;
    private Float force4;
    private Float force5;
    private Date datetime;

    public QueryDerrick(Float force1, Float force2, Float force3, Float force4, Float force5, Date datetime) {
        this.force1 = force1;
        this.force2 = force2;
        this.force3 = force3;
        this.force4 = force4;
        this.force5 = force5;
        this.datetime = datetime;
    }

    public List<Float> getForces(){
        List<Float> res = new ArrayList<>();
        res.add(force1);
        res.add(force2);
        res.add(force3);
        res.add(force4);
        res.add(force5);
        return res;
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
