package com.azusahikari.pgtools.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.msgpack.MessagePack;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CarrotJuicerUtil {

    public static void main(String[] args) {
        String path = "src/main/resources/static/CarrotJuicer";
        List<Map<String, Object>> msgpackInfo = findMsgpack(new File(path));
        log.info("{}", msgpackInfo);
    }

    public static void clearMsgpack(File folder) {
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                clearMsgpack(file);
            }
            if (file.isFile() && "msgpack".equals(getFileType(file.getName()))) {
                try {
                    JSON.parseObject(getMsgPack(file));
                } catch (Exception e) {
                    if (file.delete()) {
                        log.info("文件{}已删除", file.getName());
                    }
                }
            }
        }
    }

    public static List<Map<String, Object>> findMsgpack(File folder) {
        List<Map<String, Object>> result = new ArrayList<>();
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                result.addAll(findMsgpack(file));
            }
            if (file.isFile() && "msgpack".equals(getFileType(file.getName()))) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", file.getName());
                map.put("path", file.getPath());
                result.add(map);
            }
        }
        return result;
    }

    public static String getMsgPack(File file) {
        MessagePack messagePack = new MessagePack();
        String msgpack = "";
        try (
                InputStream inputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(inputStream)
        ) {
            msgpack = String.valueOf(messagePack.read(dataInputStream.readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msgpack;
    }

    private static String getFileType(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length - 1;
        return strArray[suffixIndex];
    }
}
