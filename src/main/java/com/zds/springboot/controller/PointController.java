package com.zds.springboot.controller;

import cn.hutool.json.JSONObject;
import com.zds.springboot.config.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2023-06-26-[上午 8:49]-周一
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/endpoint")
    public String handlerWebsocket(@RequestBody String jsonString) {
        // 使用字符串初始化JSONObject
        JSONObject stringJsonObject = new JSONObject(jsonString);
        System.out.println("JSONObject from String: " + stringJsonObject);
//        String stringJsonObject = "有新的订单";
        //发送webSocket消息
        webSocket.sendMessage(stringJsonObject);

        //下面做数据库保存

        return "success";
    }
}
