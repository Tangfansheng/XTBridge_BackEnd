package com.voyager.controller.sync;

import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("basket")
public class BasketController {
    @Autowired
    @Qualifier("BasketServiceImpl")
    BasketService basketService;


    @ResponseBody
    @RequestMapping("recent")
    public Object getRecentRecord(){
        QueryBasket recentData = basketService.findRecentData();
        List<Float> forces = recentData.getForces();
        return forces;
    }
}
