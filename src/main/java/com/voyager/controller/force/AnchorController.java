package com.voyager.controller.force;

import com.voyager.domain.QueryAnchor;
import com.voyager.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@RequestMapping("/anchor")
public class AnchorController {
    @Qualifier("anchorServiceImpl")
    @Autowired
    private AnchorService anchorService;


    @ResponseBody
    @RequestMapping("/recent")
    public Object getRecentRecord(){
        QueryAnchor recentData = anchorService.findRecentData();
        List<Float> forces = recentData.getForces();
        return forces;
    }

}
