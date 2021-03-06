package com.voyager.controller.force;

import com.voyager.domain.QueryDerrick;
import com.voyager.domain.wrapper.WrapperData;
import com.voyager.service.DerrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("derrick")
public class DerrickController {

    @Qualifier("DerrickServiceImpl")
    @Autowired
    DerrickService derrickService;

    @CrossOrigin
    @RequestMapping("recent")
    @ResponseBody
    public Object getRecentRecord(@RequestParam String vue){
        QueryDerrick recentData = derrickService.findRecentData();
        if(recentData==null){
            if(vue.equals("true")){
                return new WrapperData(null, 300);
            }else{
                return null;
            }
        }else{
            if(vue.equals("true")){
                return new WrapperData(new Object[]{recentData.getForcesMap()}, 200);
            }else{
                return recentData.getForces();
            }
        }

    }
    @CrossOrigin
    @RequestMapping("xAxis")
    @ResponseBody
    public Object getChartData(){
        List<QueryDerrick> records = derrickService.findRecent10Data();
        Collections.reverse(records);
        return records;
    }

    @CrossOrigin
    @RequestMapping("wrappedData")
    @ResponseBody
    public Object getWrappedData(){
        List<QueryDerrick> records = derrickService.findRecent10Data();
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
            map.put("name", "测点"+(i+1));
            map.put("type", "line");
            map.put("data", locForces.get(i));
            dataWrapper.add(map);
        }
        return dataWrapper;
    }


    @ResponseBody
    @CrossOrigin
    @RequestMapping("10date")
    public Object getRecent10date(){
        return derrickService.getRecent10date();
    }
}
