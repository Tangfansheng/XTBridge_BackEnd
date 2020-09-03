package com.voyager.controller.force;

import com.voyager.domain.QueryStress;
import com.voyager.service.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("stress")
public class StressController {
    @Qualifier("StressServiceImpl")
    @Autowired
    StressService stressService;


    @RequestMapping("recent")
    @ResponseBody
    public Object getRecentRecord(){
        QueryStress recentData = stressService.findRecentData();
        Map<String, Float> stressMap = recentData.getStress();
        return stressMap;
    }
}
