package com.voyager.test;


import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDerrick;
import com.voyager.domain.QueryEnv;
import com.voyager.domain.user.LoginValidation;
import com.voyager.domain.user.User;
import com.voyager.service.*;
import com.voyager.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AnchorService service = (AnchorService) context.getBean("anchorServiceImpl");
//        QueryAnchor recentData = service.findRecentData();
//        DerrickService service = (DerrickService) context.getBean("DerrickServiceImpl");
//        QueryDerrick recentData = service.findRecentData();

//        BasketService service = (BasketService) context.getBean("BasketServiceImpl");
//        QueryBasket recentData = service.findRecentData();
//        StressService service = (StressService) context.getBean("StressServiceImpl") ;
//        QueryStress recentData = service.findRecentData();

        UserService serviceImpl = (UserServiceImpl)context.getBean("UserServiceImpl");
        User user = serviceImpl.findUser("ordinary");
        System.out.println(user);
    }
    @Test
    public void run2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnchorService service = (AnchorService) context.getBean("anchorServiceImpl");
        Date date = new Date();
        QueryAnchor data = new QueryAnchor((float) 200.1, (float) 200.2, (float) 200.3, (float) 200.4, (float) 200.1, (float) 200.2, date);
        service.saveOneRecord(data);
    }
    @Test
    public void run3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)context.getBean("UserServiceImpl");
        LoginValidation validation = service.validateLogin("ordinary", "123456");
        System.out.println(validation);
    }

    @Test
    public void run4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DerrickService derrickService = (DerrickService)context.getBean("DerrickServiceImpl");
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
        List<Map<String, Object>> chartDataWrapper = new ArrayList<>();
        for(int i=0; i<locs; i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", "测点"+(i+1));
            map.put("type", "line");
            map.put("data", locForces.get(i));
            chartDataWrapper.add(map);
            //for test
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey()+ "  "+ entry.getValue());
            }
        }
    }
    @Test
    public void run5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EnvService service = (EnvService)context.getBean("EnvServiceImpl");
        QueryEnv env = service.getEnv();
        System.out.println(env);


    }
}
