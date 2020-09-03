package com.voyager.controller.force;

import com.voyager.domain.QueryDerrick;
import com.voyager.service.DerrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("derrick")
public class DerrickController {

    @Qualifier("DerrickServiceImpl")
    @Autowired
    DerrickService derrickService;

    @RequestMapping("recent")
    @ResponseBody
    public Object getRecentRecord(){
        QueryDerrick recentData = derrickService.findRecentData();
        List<Float> list = recentData.getForces();
        return list;
    }

}
