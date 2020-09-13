package com.voyager.domain.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.voyager.domain.QueryDerrick;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WrapperData {
    Map<String, Object> map = new HashMap<>();

    public WrapperData(Object data, int code) {
        map.put("data", data);
        map.put("code", code);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
