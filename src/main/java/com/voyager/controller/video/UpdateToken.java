package com.voyager.controller.video;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.voyager.domain.TokenResp;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class UpdateToken {
    @CrossOrigin
    @ResponseBody
    @RequestMapping("token")
    public Object updateToken() {
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
