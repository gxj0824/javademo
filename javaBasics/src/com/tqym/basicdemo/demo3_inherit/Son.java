package com.tqym.basicdemo.demo3_inherit;

/**
 * @ClassName Son
 * @Description 子类
 * @Author 洛城天使
 * @Date: 2021/9/22 22:20
 * @Version 1.0
 */
public class Son extends Parent{

    public static String money = "儿子:100";
    public String name = "儿子:小头";

    public static void eat(){
        System.out.println("儿子吃小麦");
    }
    public void play(){
        System.out.println("儿子玩游戏");
    }

}
