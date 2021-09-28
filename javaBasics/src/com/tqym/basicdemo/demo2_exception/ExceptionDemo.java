package com.tqym.basicdemo.demo2_exception;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName ExceptionDemo
 * @Description 异常测试
 * @Author 洛城天使
 * @Date: 2021/9/21 16:25
 * @Version 1.0
 */
public class ExceptionDemo {
    /**
     * 使用 try...catch...finally 代码块处理异常
     */
    @Test
    public void testIOTryCatch1() {
        //提高变量fw的作用域,让finally可以使用
        //变量在定义的时候,可以没有值,但是使用的时候必须有值
        //fw = new FileWriter("09_IOAndProperties\\g.txt",true);
        // 执行失败,fw没有值,fw.close会报错
        FileWriter fw = null;
        try {
            //可能会产出异常的代码
            fw = new FileWriter(Constant.E_JAVA_TEST_TXT, true);
            for (int i = 0; i < 5; i++) {
                fw.write("可不要忘记，你要相信你自己！" + i + "\r\n");
            }
        } catch (IOException e) {
            //异常的处理逻辑
            System.out.println(e.toString());
        } finally {
            //创建对象失败了,fw的默认值就是null,null是不能调用方法的,
            //会抛出NullPointerException,需要增加一个判断,不是null在把资源释放
            if (fw != null) {
                try {
                    //fw.close方法声明抛出了IOException异常对象,
                    // 所以我们就的处理这个异常对象,要么throws,要么try catch
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * try-with-resource 语句，该语句确保了每个资源在语句结束时关闭。
     * 所谓的资源 （resource）是指在程序完成后，必须关闭的对象。
     */
    @Test
    public void testIOTryCatch2() {
        try (//1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
             FileInputStream fis = new FileInputStream(Constant.C_COPY_KOBE1_JPG);
             //2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
             FileOutputStream fos = new FileOutputStream(Constant.E_PATH + "Kobe3.jpg")) {

            //一次读取一个字节写入一个字节的方式
            //3.使用字节输入流对象中的方法read读取文件
            int len = 0;
            while ((len = fis.read()) != -1) {
                //4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
                fos.write(len);
            }

        } catch (IOException e) {
            //异常的处理逻辑
            System.out.println(e.toString());
        }
    }

}
