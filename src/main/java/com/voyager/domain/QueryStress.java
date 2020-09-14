package com.voyager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

public class QueryStress {
    private Float upper;
    private Float front;
    private Float mid;
    private Float rear;
    private Float bottom;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date datetime;

    public QueryStress(Float upper, Float front, Float mid, Float rear, Float bottom, Date datetime) {
        this.upper = upper;
        this.front = front;
        this.mid = mid;
        this.rear = rear;
        this.bottom = bottom;
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }


    public List<Float> getForces(){
        List<Float> res = new ArrayList<>();
        res.add(this.upper);
        res.add(this.front);
        res.add(this.mid);
        res.add(this.rear);
        res.add(this.bottom);
        return res;
     }

    /**
     * 给Vue填表格用的
     * @return
     */
    public Map<String, Object> getStress(){
        Map<String, Object> map = new HashMap<>();
        map.put("upper", upper);
        map.put("front", front);
        map.put("mid", mid);
        map.put("rear", rear);
        map.put("bottom", bottom);
        map.put("datetime", this.datetime);
        return map;
    }

    @Override
    public String toString() {
        return "QueryStress{" +
                "upper=" + upper +
                ", front=" + front +
                ", mid=" + mid +
                ", rear=" + rear +
                ", bottom=" + bottom +
                ", datetime=" + datetime +
                '}';
    }
}
