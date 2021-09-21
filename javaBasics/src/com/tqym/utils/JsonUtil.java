package com.tqym.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description Json数据与其他数据转换
 * @Author 洛城天使
 * @Date 2021/9/21 16:25
 * @Version 1.0
 */
public class JsonUtil {

    //java对象转json字符串
    public static String objectToJson(Object object) {
        String jsonString = JSONObject.toJSONString(object);
        return jsonString;
    }

    //map转json字符串
    public static String mapToJson(Map<String, Object> map) {
        String jsonString = JSONObject.toJSONString(map);
        return jsonString;
    }

    //java对象转json对象
    public static JSONObject objectToJsonObject(Object object) {
        Object obj = JSON.toJSON(object);
        JSONObject jsonObject = JSONObject.parseObject(obj.toString());
        return jsonObject;
    }

    //map转json对象
    public static JSONObject mapToJsonObject(Map<String, Object> map) {
        Object obj = JSON.toJSON(map);
        JSONObject jsonObject = JSONObject.parseObject(obj.toString());
        return jsonObject;
    }

    //json对象转map
    public static Map jsonObjectToMap(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        map.putAll(jsonObject);
        return map;
    }

    //json字符串转map:先转成JSONObject
    public static Map jsonToMap(String json_str) {
        //1.json字符串先转成JSONObject
        JSONObject jsonObject = JSONObject.parseObject(json_str);
        //2.json对象转map
        Map<String, Object> map = new HashMap<>();
        map.putAll(jsonObject);
        return map;
    }

}
