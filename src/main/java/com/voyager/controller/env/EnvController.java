package com.voyager.controller.env;

import com.voyager.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class EnvController {
    @Autowired
    @Qualifier("EnvServiceImpl")
    private EnvService envService;

    @RequestMapping("env")
    @ResponseBody
    public Object getEnv(){
        return new Object[]{envService.getEnv()};
    }
}
