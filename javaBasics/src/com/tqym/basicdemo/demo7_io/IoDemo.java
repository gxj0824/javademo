package com.tqym.basicdemo.demo7_io;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName IoDemo
 * @Description 测试字节流和字符流
 * @Author 洛城天使
 * @Date: 2021/9/27 22:55
 * @Version 1.0
 */
public class IoDemo {

    /**
     * 文件复制
     */
    @Test
    public void testCopyFile() throws IOException {

        Path src = Paths.get(Constant.C_COPY_KOBE1_JPG);
        Path des = Paths.get(Constant.E_PATH + "kobe.jpg");
        Path copy = Files.copy(src, des);
        System.out.println(copy);

        // 1.创建流对象
        /*FileInputStream fis = new FileInputStream(Constant.C_COPY_KOBE1_JPG);
        FileOutputStream fos = new FileOutputStream(Constant.E_PATH + "kobe.jpg");
        // 2.读写数据
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }
        // 3.关闭资源
        fos.close();
        fis.close();*/

    }

    /**
     * 方式二：（字符流）FileWriter写入文件
     */
    @Test
    public void test() throws IOException {

        //1.创建FileWriter对象,构造方法中绑定要写入数据的目的地，并打开追加功能
        FileWriter fw = new FileWriter(Constant.E_JAVA_TEST_TXT, false);
        //2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
        char[] cs = {'b', 'r', 'y', 'a', 'n', 't'};

        //void write(char[] cs)写入字符数组。
        fw.write(cs);//bryant
        fw.write("\r\n");
        //void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        fw.write(cs, 1, 3);//rya
        fw.write("\r\n");

        //使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中,刷新之后流可以继续使用
        //fw.flush();

        //void write(String str)写入字符串。
        fw.write("我站在屋顶");//你好呀
        fw.write("\r\n");
        //void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        fw.write("黄昏的光景", 3, 2);//光景
        fw.write("\r\n");

        //释放资源(会先把内存缓冲区中的数据刷新到文件中),流就不能再使用了
        fw.close();

    }

    /**
     * 方式一：（字节流）OutputStream写入文件
     */
    @Test
    public void testOutputStream() throws IOException {
        //创建FileOutputStream对象,构造方法中绑定要写入数据的目的地，打开追加功能
        FileOutputStream fos = new FileOutputStream(Constant.E_JAVA_TEST_TXT, true);
        //调用FileOutputStream对象中的方法write,把数据写入到文件中
        //在文件中显示10,写个字节
        fos.write(49);
        fos.write(48);
        fos.write("\r\n".getBytes());

        //一次写多个字节:KOBE
        byte[] bytes = {75, 79, 66, 69};
        fos.write(bytes);
        fos.write("\r\n".getBytes());

        //把字节数组的一部分写入到文件中:OB
        fos.write(bytes, 1, 2);
        fos.write("\r\n".getBytes());

        //可以使用String类中的方法把字符串,转换为字节数组
        byte[] bytes2 = "你要相信你自己！".getBytes();
        fos.write(bytes2);
        fos.write("\r\n".getBytes());

        //释放资源
        fos.close();
    }

    /**
     * 方式三：Scanner读取文件
     */
    @Test
    public void testScanner() throws IOException {
        //操作文本文件
        Scanner in = new Scanner(Paths.get(Constant.E_JAVA_TEST_TXT), "UTF-8");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }

    /**
     * 方式二：（字符流）FileReader读取文件
     */
    @Test
    public void testFileReader() throws IOException {
        //1.创建FileReader对象,构造方法中绑定要读取的数据源
        FileReader fr = new FileReader(Constant.E_JAVA_TEST_TXT);
        //2.使用FileReader对象中的方法read读取文件
        //int read(char[] cs）次读取多个字符,将字符读入数组。
        char[] cs = new char[1024];//存储读取到的多个字符
        int len = 0;//记录的是每次读取的有效字符个数
        while ((len = fr.read(cs)) != -1) {
            System.out.println(new String(cs, 0, len));
        }
        //3.释放资源
        fr.close();

    }

    /**
     * 方式一：（字节流）InputStream读取文件
     */
    @Test
    public void testInputStream() throws IOException {
        //创建FileInputStream对象,构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream(Constant.E_JAVA_TEST_TXT);
        //存储读取到的多个字节
        byte[] bytes = new byte[1024];
        //记录每次读取的有效字节个数
        int len = 0;
        //使用FileInputStream对象中的方法read读取文件
        //int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        //String(byte[] bytes, int offset, int length) 把字节数组一部分转换为字符串 。offset：数组的开始索引； length：转换的字节个数。
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //释放资源
        fis.close();
    }

}
