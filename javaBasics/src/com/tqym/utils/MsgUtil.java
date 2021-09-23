package com.tqym.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Description 返回Json字符串工具类
 * @Author 洛城天使
 * @Date 2021/9/21 16:25
 * @Version 1.0
 **/
public class MsgUtil {

    /**
     * 传入String可变参数的返回值
     */
    public static String successMsg(String... str) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        if (str.length == 0) {
            return jsonObject.toJSONString();
        } else if (str.length == 1) {
            jsonObject.put("data", str[0]);
            return jsonObject.toJSONString();
        } else if (str.length % 2 != 0) {
            return "请输入大于1的偶数个参数";
        } else {
            for (int i = 0; i < str.length; i++) {
                jsonObject.put(str[i], str[i++]);
            }
        }
        return jsonObject.toJSONString();
    }

    /**
     * 传入Map参数的返回值
     */
    public static String successMsg(Map map) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put("data", JSONObject.parseObject(JSON.toJSON(map).toString()));
        return jsonObject.toJSONString();
    }

    /**
     * 传入List参数的返回值
     */
    public static String successMsg(List list) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put("data", new JSONArray().addAll(list));
        return jsonObject.toJSONString();
    }


    public static String errorMsg() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        return jsonObject.toJSONString();
    }

    public static String errorMsg(String failInfo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "error");
        jsonObject.put("info", failInfo);
        return jsonObject.toJSONString();
    }

    public static String errorMsg(Map map) {
        return JSONObject.parseObject(JSON.toJSON(map).toString()).toJSONString();
    }


}
