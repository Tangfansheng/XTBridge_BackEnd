package com.voyager.controller.force;

import com.voyager.domain.QueryDerrick;
import com.voyager.domain.QueryStress;
import com.voyager.service.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@CrossOrigin
@Controller
@RequestMapping("stress")
public class StressController {
    private String[] names = {"上平杆", "前斜杆", "立柱", "后拉杆", "下平杆"};
    @Qualifier("StressServiceImpl")
    @Autowired
    StressService stressService;


    @RequestMapping("recent")
    @ResponseBody
    public Object getRecentRecord(@RequestParam String vue){
        QueryStress recentData = stressService.findRecentData();
        if(vue.equals("true")){
            return new Object[]{recentData.getStress()};
        }
        Map<String, Object> stressMap = recentData.getStress();
        return stressMap;
    }


    @RequestMapping("xAxis")
    @ResponseBody
    public Object getChartData(){
        List<QueryStress> records = stressService.findRecent10Data();
        Collections.reverse(records);
        return records;
    }

    @RequestMapping("wrappedData")
    @ResponseBody
    public Object getWrappedData(){
        List<QueryStress> records = stressService.findRecent10Data();
        List<List<Float>> locForces = new ArrayList<>();

        int locs = records.get(0).getForces().size();
        for(int k=0; k<locs; k++){
            locForces.add(new ArrayList<Float>());
        }
        for(int i=0; i<records.size(); i++){
            //10个历史数据
            List<Float> forces = records.get(i).getForces();
            for(int j=0; j<locs; j++){
                //5个测点
                locForces.get(j).add(forces.get(j));
            }
        }
        List<Map<String, Object>> dataWrapper = new ArrayList<>();
        for(int i=0; i<locs; i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("type", "line");
            map.put("data", locForces.get(i));
            dataWrapper.add(map);
        }
        Collections.reverse(dataWrapper);
        return dataWrapper;
    }
}
