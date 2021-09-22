package com.tqym.basicdemo.demo3_inherit;

/**
 * @ClassName Parent
 * @Description 父类
 * @Author 洛城天使
 * @Date: 2021/9/22 22:20
 * @Version 1.0
 */
public class Parent {
    public static String age = "父亲:20";
    public static String money = "父亲:100";
    public String name = "父亲:大狗";
    public String sex = "父亲:男";

    public static void say(){
        System.out.println("我是父亲");
    }

    public static void eat(){
        System.out.println("父亲吃米饭");
    }

    public void play(){
        System.out.println("父亲玩篮球");
    }

    public void sleep(){
        System.out.println("父亲谁沙发");
    }
}
