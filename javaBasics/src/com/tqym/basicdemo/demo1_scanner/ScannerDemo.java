package com.tqym.basicdemo.demo1_scanner;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
/**
 * @ClassName Scanner
 * @Description 测试scanner类
 * @Author 洛城天使
 * @Date: 2021/9/12 22:50
 * @Version 1.0
 */
public class ScannerDemo {
    @Test
    public void testScanner() throws IOException {
        String filePath = Constant.E_JAVA_TEST_TXT;
        PrintWriter writer = new PrintWriter(filePath, "UTF-8");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一些字：");
        boolean flag = true;
        while (flag) {
            String str = scanner.nextLine();
            if ("exit".equals(str)) {
                System.out.println("====================");
                flag = false;
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
