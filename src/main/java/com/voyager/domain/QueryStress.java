package com.voyager.domain;

import java.util.*;

public class QueryStress {
    private Float upper;
    private Float front;
    private Float mid;
    private Float rear;
    private Float bottom;
    private Date datetime;

    public QueryStress(Float upper, Float front, Float mid, Float rear, Float bottom, Date datetime) {
        this.upper = upper;
        this.front = front;
        this.mid = mid;
        this.rear = rear;
        this.bottom = bottom;
        this.datetime = datetime;
    }

    public Map<String, Float> getStress(){
        Map<String, Float> map = new HashMap<>();
        map.put("upper", upper);
        map.put("front", front);
        map.put("mid", mid);
        map.put("rear", rear);
        map.put("bottom", bottom);
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
