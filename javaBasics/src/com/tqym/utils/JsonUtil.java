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

    /**
     * java对象转json字符串
     */
    public static String objectToJson(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * map转json字符串
     */
    public static String mapToJson(Map<String, Object> map) {
        return JSONObject.toJSONString(map);
    }


    /**
     * java对象转json对象
     */
    public static JSONObject objectToJsonObject(Object object) {
        Object obj = JSON.toJSON(object);
        return JSONObject.parseObject(obj.toString());
    }

    /**
     * map转json对象
     */
    public static JSONObject mapToJsonObject(Map<String, Object> map) {
        Object obj = JSON.toJSON(map);
        return JSONObject.parseObject(obj.toString());
    }

    /**
     * json对象转map
     */
    public static Map jsonObjectToMap(JSONObject jsonObject) {
        return new HashMap<>(jsonObject);
    }

    /**
     * json字符串转map
     */
    public static Map jsonToMap(String jsonStr) {
        //1.json字符串先转成JSONObject
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        //2.json对象转map
        return new HashMap<>(jsonObject);
    }

}
