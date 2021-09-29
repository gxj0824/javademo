package com.tqym.basicdemo.demo8_otherIo;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description 测试序列化流需要用到的类
 * @Author 洛城天使
 * @Date: 2021/9/29 21:54
 * @Version 1.0
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    //被transient修饰成员变量,不能被序列化
    private transient String sex;
    private int age;

    public Person() {
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //省略toString方法和get、set方法


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
