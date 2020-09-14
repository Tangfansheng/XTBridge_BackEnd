package com.voyager.controller.sync;

import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.BasketService;
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
@RequestMapping("basket")
public class BasketController {

    @Autowired
    @Qualifier("BasketServiceImpl")
    BasketService basketService;


    @ResponseBody
    @RequestMapping("recent")
    public Object getRecentRecord(@RequestParam String vue){
        QueryBasket recentData = basketService.findRecentData();
        if(vue.equals("true")){
            return  new Object[]{recentData.getForcesMap()};
        }
        List<Float> forces = recentData.getForces();
        return forces;
    }

    @CrossOrigin
    @RequestMapping("xAxis")
    @ResponseBody
    public Object get_xAxis(){
        List<QueryBasket> records = basketService.findRecent10Data();
        Collections.reverse(records);
        return records;
    }

    @CrossOrigin
    @RequestMapping("wrappedData")
    @ResponseBody
    public Object getWrappedData(){
        List<QueryBasket> records = basketService.findRecent10Data();
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


}
