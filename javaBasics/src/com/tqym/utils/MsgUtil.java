package com.tqym.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @Description 返回Json消息工具类
 * @Author 洛城天使
 * @Date 2021/9/21 16:25
 * @Version 1.0
 **/
public class MsgUtil {

    public static String successMsg() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        return jsonObject.toJSONString();

    }

    public static String successMsg(String content) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put("infomation", content);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type, String content) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put(type, content);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type1, String content1, String type2, String content2) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put(type1, content1);
        jsonObject.put(type2, content2);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type, Map map) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        Object obj = JSON.toJSON(map);
        JSONObject mapobj = JSONObject.parseObject(obj.toString());
        jsonObject.put(type, mapobj);
        return jsonObject.toJSONString();
    }


    public static String successMsg(String type, List list) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {

            jsonArray.add(list.get(i));

        }
        jsonObject.put(type, jsonArray);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type1, List list1, String type2, List list2) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < list1.size(); i++) {
            jsonArray1.add(list1.get(i));
        }
        jsonObject.put(type1, jsonArray1);
        JSONArray jsonArray2 = new JSONArray();
        for (int j = 0; j < list1.size(); j++) {
            jsonArray2.add(list2.get(j));
        }
        jsonObject.put(type2, jsonArray2);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type1, String content1, String type2, List list1, String type3, List list2) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put(type1, content1);
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < list1.size(); i++) {
            jsonArray1.add(list1.get(i));
        }
        jsonObject.put(type2, jsonArray1);
        JSONArray jsonArray2 = new JSONArray();
        for (int j = 0; j < list1.size(); j++) {
            jsonArray2.add(list2.get(j));
        }
        jsonObject.put(type3, jsonArray2);
        return jsonObject.toJSONString();

    }

    public static String successMsg(String type1, String content1, String type2, List list2) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "ok");
        jsonObject.put(type1, content1);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list2);
        jsonObject.put(type2, jsonArray);
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
        jsonObject.put("failInfo", failInfo);
        return jsonObject.toJSONString();

    }

    public static String errorMsg(Map map) {
        Object obj = JSON.toJSON(map);
        JSONObject mapobj = JSONObject.parseObject(obj.toString());
        return mapobj.toJSONString();
    }

}
