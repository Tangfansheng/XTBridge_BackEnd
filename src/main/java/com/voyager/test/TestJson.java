package com.voyager.test;



import com.alibaba.fastjson.JSON;

import com.voyager.domain.user.User;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class TestJson {
    @Test
    public void run1(){
        String jsonObject  = "{\"force4\":200.4,\"force3\":200.3,\"InsertDate\":\"2020-09-01\",\"force2\":200.2,\"force1\":200.1}";
        String jsonArray = "[200.1,200.2,200.3,200.4]";
        List<Float> list = JSON.parseArray(jsonArray, Float.class);
        for(Float force : list){
            System.out.println(force);
        }

    }
    @Test
    public void run2() throws IOException {
        URL url = new URL("http://127.0.0.1:8081/anchor/list");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine())!=null){
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        System.out.println(sb.toString());
    }

    @Test
    public void run3() throws IOException {
        URL url = new URL("http://120.26.187.166:8080/XTBridge_war/stress/recent");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine())!=null){
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        System.out.println(sb.toString());

    }
    @Test
    public void run4(){
        String data = "{\"rear\":100.4,\"bottom\":100.5,\"upper\":100.1,\"mid\":100.3,\"front\":100.2}";
        Map<String, Float> map = (Map<String, Float>) JSON.parse(data);
        for (Object obj : map.keySet()){
            System.out.println("key为："+obj+"值为："+map.get(obj));
        }
    }

    @Test
    public void run5(){
        String data = "{\"username\":\"admin\",\"password\":\"XTBridge\",\"permission\":1}";
        User user = JSON.parseObject(data, User.class);
        System.out.println(user);
    }
}
