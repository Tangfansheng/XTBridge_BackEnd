package com.voyager.domain.sync;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

public class QueryBasket {
    private Float force1;
    private Float force2;
    private Float force3;
    private Float force4;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date datetime;

    public QueryBasket(Float force1, Float force2, Float force3, Float force4, Date datetime) {
        this.force1 = force1;
        this.force2 = force2;
        this.force3 = force3;
        this.force4 = force4;
        this.datetime = datetime;
    }



    public List<Float> getForces(){
        List<Float> res = new ArrayList<>();
        res.add(force1);
        res.add(force2);
        res.add(force3);
        res.add(force4);
        return res;
    }


    /**
     * 给Vue填表格用的
     * @return
     */
    public Map<String, Object> getForcesMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("force1", force1);
        map.put("force2", force2);
        map.put("force3", force3);
        map.put("force4", force4);
        map.put("datetime", datetime);
        return map;
    }

    public Date getDatetime() {
        return datetime;
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
}
