package com.voyager.domain.wrapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartUnit {
     Map<String, Object> wrappedChartDataUnit = new HashMap<>();

    /**
     * 封装chart所需要的数据
     * @param loc 测点1 ..测点n
     * @param forces 某个测点的近10个数据
     */
     public ChartUnit(String loc, List<Float> forces){
        wrappedChartDataUnit.put("name", loc);
        wrappedChartDataUnit.put("data", forces);
        wrappedChartDataUnit.put("type", "line");
     }


}
