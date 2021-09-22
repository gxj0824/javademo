package com.tqym.basicdemo.demo3_inherit;

/**
 * @ClassName TestInherit
 * @Description 测试继承的相关调用
 * @Author 洛城天使
 * @Date: 2021/9/22 22:28
 * @Version 1.0
 */
public class TestInherit {
    public static void main(String[] args) {

        //1、继承中访问成员变量
        //在父子类的继承关系当中，如果成员变量重名，则创建子类对象时：
        //直接通过子类对象访问成员变量：等号左边是谁，就优先用谁，没有则向上找。
        //2、继承中访问成员方法
        //在父子类的继承关系当中，则创建子类对象时，访问成员方法的规则：
        //创建的对象是谁，就优先用谁，如果没有则向上找。
        Parent ps = new Son();
        System.out.println(ps.money);
        System.out.println(ps.name);
        System.out.println(ps.age);
        System.out.println(ps.sex);
        ps.play();
        ps.sleep();
        ps.eat();
        ps.say();
        
    }
}
