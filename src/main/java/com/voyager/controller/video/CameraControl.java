package com.voyager.controller.video;

import com.alibaba.fastjson.JSON;
import com.voyager.domain.TokenResp;
import okhttp3.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
@CrossOrigin
@Controller
@RequestMapping("camera")
public class CameraControl {
    String accessToken = "";

    @CrossOrigin
    @RequestMapping("move")
    @ResponseBody
    public String control(@RequestParam int direction){
        if(accessToken == ""){
            accessToken = getToken();
        }
        System.out.println("move");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        String url = String.format("https://open.ys7.com/api/lapp/device/ptz/start?accessToken=%s&deviceSerial=C79361726&channelNo=1&speed=2&direction=%s", accessToken, direction);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    @CrossOrigin
    @RequestMapping("stop")
    @ResponseBody
    public String stop(){
        if(accessToken == ""){
            accessToken = getToken();
        }
        System.out.println("stop");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        String url = String.format("https://open.ys7.com/api/lapp/device/ptz/stop?accessToken=%s&deviceSerial=C79361726&channelNo=1", accessToken);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public String getToken(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://open.ys7.com/api/lapp/token/get?appKey=88c91fcdcb294f7b9a99c4cb6b3d57d6&appSecret=dc61b339154add26669d09f97ff7a95d")
                .method("POST", body)
                .build();
        Response response = null;
        TokenResp resp = null;
        try {
            response = client.newCall(request).execute();
            resp = JSON.parseObject(response.body().string(), TokenResp.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp.getData().getAccessToken();
    }

}
