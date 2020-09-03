package com.voyager.domain.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryBasket {
    private Float force1;
    private Float force2;
    private Float force3;
    private Float force4;
    private Date datetime;

    public QueryBasket(Float force1, Float force2, Float force3, Float force4, Date datetime) {
        this.force1 = force1;
        this.force2 = force2;
        this.force3 = force3;
        this.force4 = force4;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "QueryBasket{" +
                "force1=" + force1 +
                ", force2=" + force2 +
                ", force3=" + force3 +
                ", force4=" + force4 +
                ", datetime=" + datetime +
                '}';
    }

    public List<Float> getForces(){
        List<Float> res = new ArrayList<>();
        res.add(force1);
        res.add(force2);
        res.add(force3);
        res.add(force4);
        return res;
    }

}
