package com.tqym.demo1_scanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName Scanner
 * @Description 测试scanner类
 * @Author guanxiaojing
 * @Date: 2021/9/12 22:50
 * @Version 1.0
 */
public class ScannerDemo {
    public static void main(String[] args) {
        try {
            testScanner();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testScanner() throws IOException {
        String filePath = "E:\\demofile\\javatest.txt";

        PrintWriter writer = new PrintWriter(filePath, "UTF-8");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一些字：");
        boolean falg = true;
        while (falg) {
            String str = scanner.nextLine();
            if ("exit".equals(str)) {
                System.out.println("====================");
                falg = false;
                writer.close();
            } else {
                writer.println(str);
                writer.flush();
            }
        }

        Scanner in = new Scanner(Paths.get(filePath), "UTF-8");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

    }
}
