package com.tqym.basicdemo.demo6_file;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName FileDemo
 * @Description 测试 File类
 * @Author 洛城天使
 * @Date: 2021/9/27 22:36
 * @Version 1.0
 */
public class FileDemo {
    //测试File类文件操作
    @Test
    public void testFile() {
        File file = new File("E:/demofile");

        printDir1(file);
    }

    /**
     * 打印文件
     * （文件过滤器优化）
     */
    private static void printDir2(File dir) {
        //匿名内部类方式,创建过滤器子类对象
        /*File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt") || pathname.isDirectory();
            }
        });*/

        //lambda的改写
        File[] files = dir.listFiles(f -> f.getName().endsWith(".txt") || f.isDirectory());
        if (files != null && files.length != 0) {
            // 循环打印
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("文件名:" + file.getAbsolutePath());
                } else {
                    printDir2(file);
                }
            }
        }

    }

    /**
     * 打印目录方法和文件
     */
    private static void printDir1(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        if (files != null && files.length != 0) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("文件名:" + file.getAbsolutePath());
                    }
                } else {
                    printDir1(file);
                }
            }
        }
    }


}
