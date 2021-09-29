package com.tqym.basicdemo.demo8_otherIo;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * @ClassName OtherIoDemo
 * @Description 测试缓冲流、转换流、序列化流、打印流等操作
 * @Author 洛城天使
 * @Date: 2021/9/28 23:20
 * @Version 1.0
 */
public class OtherIoDemo {

    /**
     * 测试打印流
     */
    @Test
    public void testPrintStream() throws IOException {
        //创建打印流PrintStream对象,构造方法中绑定要输出的目的地
        PrintStream ps = new PrintStream(Constant.E_PATH + "print.txt");

        //如果使用继承自父类的write方法写数据,那么查看数据的时候会查询编码表 97->a
        ps.write(97);
        ps.write("\r\n".getBytes());
        //如果使用自己特有的方法print/println方法写数据,写的数据原样输出 97->97
        ps.println(97);
        ps.println(8.8);
        ps.println('a');
        ps.println("HelloWorld");
        ps.println(true);

        System.out.println("请输入歌词：");
        System.setOut(ps);//把输出语句的目的地改变为打印流的目的地
        System.out.println("我输入的歌词：");
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String data = in.nextLine();
            if (Objects.equals(data, "out")) {
                flag = false;
                ps.close();
            } else {
                System.out.println(data);
            }
        }
        //释放资源
        ps.close();
    }


    /**
     * 测试序列化流
     */
    @Test
    public void testObjectStream() throws IOException, ClassNotFoundException {
        //1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list = new ArrayList<>();
        //2.往ArrayList集合中存储Person对象
        list.add(new Person("张三", "男", 18));
        list.add(new Person("李四", "男", 19));
        list.add(new Person("王五", "男", 20));
        //3.创建一个序列化流ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constant.E_PATH + "obj.txt"));
        //4.使用ObjectOutputStream对象中的方法writeObject,对集合进行序列化
        oos.writeObject(list);
        //5.创建一个反序列化ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constant.E_PATH + "obj.txt"));
        //6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
        Object o = ois.readObject();
        //7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> personList = (ArrayList<Person>) o;
        //8.遍历ArrayList集合
        for (Person p : personList) {
            System.out.println(p);
        }
        //9.释放资源
        ois.close();
        oos.close();
    }


    /**
     * 测试转换流
     * 将GBK编码的文本文件，转换为UTF-8编码的文本文件。
     */
    @Test
    public void testReverseStream() throws IOException {
        //1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称GBK
        InputStreamReader isr = new InputStreamReader(new FileInputStream(Constant.E_PATH + "gbk.txt"), "GBK");
        //2.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(Constant.E_PATH + "utf8.txt"), StandardCharsets.UTF_8);
        //3.使用InputStreamReader对象中的方法read读取文件
        char[] cs = new char[1024];//存储读取到的多个字符
        int len = 0;//记录的是每次读取的有效字符个数
        while ((len = isr.read(cs)) != -1) {
            //4.使用OutputStreamWriter对象中的方法write,把读取的数据写入到文件中
            osw.write(cs, 0, len);
            System.out.println(new String(cs, 0, len));
        }
        //5.释放资源
        osw.close();
        isr.close();
    }


    /**
     * 测试缓冲字符流复制文件
     * 3.侍中、侍郎郭攸之、费祎、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗陛下。愚以为宫中之事，事无大小，悉 以咨之，然后施行，必得裨补阙漏，有所广益。
     * 2.宫中府中，俱为一体，陟罚臧否，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不 宜偏私，使内外异法也。
     * 1.先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外 者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以 塞忠谏之路也。
     */
    @Test
    public void testBuffered() throws IOException {
        //1.创建一个HashMap集合对象,可以:存储每行文本的序号(1,2,3,..);value:存储每行的文本
        HashMap<String, String> map = new HashMap<>();
        //2.创建字符缓冲输入流对象,构造方法中绑定字符输入流
        BufferedReader br = new BufferedReader(new FileReader(Constant.E_JAVA_TEST_TXT));
        //3.创建字符缓冲输出流对象,构造方法中绑定字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.E_PATH + "out.txt"));
        //4.使用字符缓冲输入流中的方法readline,逐行读取文本
        String line;
        while ((line = br.readLine()) != null) {
            //5.对读取到的文本进行切割,获取行中的序号和文本内容
            String[] arr = line.split("\\.");
            //6.把切割好的序号和文本的内容存储到HashMap集合中(key序号是有序的,会自动排序1,2,3,4..)
            map.put(arr[0], arr[1]);
        }

        //7.遍历HashMap集合,获取每一个键值对
        for (String key : map.keySet()) {
            String value = map.get(key);
            //8.把每一个键值对,拼接为一个文本行
            line = key + "." + value;
            //9.把拼接好的文本,使用字符缓冲输出流中的方法write,写入到文件中
            bw.write(line);
            bw.newLine();//写换行
        }
        //10.释放资源
        bw.close();
        br.close();
    }


    /**
     * 测试缓冲字节流复制文件
     */
    @Test
    public void testBufferedStream() throws IOException {
        // 创建流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Constant.C_COPY_KOBE1_JPG));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Constant.E_PATH + "ko.jpg"));

        //int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        byte[] bytes = new byte[1024];//存储每次读取的数据
        int len = 0; //记录每次读取的有效字节个数
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        /*int available = bis.available();
        if (available>0) {
            byte[] bytes = new byte[available];//存储每次读取的数据
            bos.write(bytes);
        }*/

        //4.释放资源
        bos.close();
        bis.close();
    }
}
