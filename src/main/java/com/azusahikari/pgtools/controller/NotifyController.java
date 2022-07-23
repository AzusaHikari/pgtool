package com.azusahikari.pgtools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.MessagePack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/notify")
public class NotifyController {

    @ResponseBody
    @RequestMapping(value = "/response")
    public Map<String, Object> notifyListener(@RequestBody byte[] bytes) {
        Map<String, Object> response = new HashMap<>();
        response.put("tranOk", "0");
        MessagePack messagePack = new MessagePack();
        try {
            String str = String.valueOf(messagePack.read(bytes));
            JSONObject root = JSON.parseObject(str);
            log.info(String.valueOf(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
