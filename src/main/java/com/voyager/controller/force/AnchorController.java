package com.voyager.controller.force;

import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDerrick;
import com.voyager.domain.wrapper.WrapperData;
import com.voyager.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("/anchor")
public class AnchorController {
    @Qualifier("anchorServiceImpl")
    @Autowired
    private AnchorService anchorService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/recent")
    public Object getRecentRecord(@RequestParam String dataStructure){
        QueryAnchor recentData = anchorService.findRecentData();
        if(recentData==null){
            return new WrapperData(null, 300);
        }
        if(dataStructure.equals("map")){
            return new WrapperData(new Object[]{recentData.getForcesMap()}, 200);
        }else{
            return new WrapperData(recentData, 200);
        }
    }

    @CrossOrigin
    @RequestMapping("xAxis")
    @ResponseBody
    public Object getChartData(){
        List<QueryAnchor> records = anchorService.findRecent10Data();
        Collections.reverse(records);
        return records;
    }

    @CrossOrigin
    @RequestMapping("wrappedData")
    @ResponseBody
    public Object getWrappedData(){
        List<QueryAnchor> records = anchorService.findRecent10Data();
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
