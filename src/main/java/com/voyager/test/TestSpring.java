package com.voyager.test;


import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDerrick;
import com.voyager.domain.QueryStress;
import com.voyager.domain.login.User;
import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.*;
import com.voyager.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


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
}
