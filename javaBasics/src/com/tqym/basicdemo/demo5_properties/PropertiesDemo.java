package com.tqym.basicdemo.demo5_properties;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @ClassName PropertiesDemo
 * @Description 测试Properties类
 * @Author 洛城天使
 * @Date: 2021/9/23 21:37
 * @Version 1.0
 */
public class PropertiesDemo {

    /**
     * 利用Properties读取配置文件
     */
    @Test
    public void testProperties3() throws IOException {
        Properties properties = new Properties();
        //方式一：使用ClassLoader加载properties配置文件生成对应的输入流
        //该方式只能读取类路径下的配置文件，有局限但是如果配置文件在类路径下比较方便。
        //InputStream in = JavaTest.class.getClassLoader().getResourceAsStream("config/log4j.properties");

        //方式二：使用InPutStream流读取properties文件
        //该方式的优点在于可以读取任意路径下的配置文件。
        BufferedReader in = new BufferedReader(new FileReader("E:\\demofile\\log4j.properties"));

        // 使用properties对象加载输入流
        properties.load(in);
        //获取key对应的value值
        String property = properties.getProperty("log4j.appender.file.File");
        System.out.println(property);

        //方式三：通过 java.util.ResourceBundle 类来读取
        //log4j为属性文件名，放在包com.test.config下，如果是放在src下，直接用log4j即可
        //①通过 ResourceBundle.getBundle() 静态方法来获取（ResourceBundle是一个抽象类），
        // 这种方式来获取properties属性文件不需要加.properties后缀名，只需要文件名即可。
        ResourceBundle resource1 = ResourceBundle.getBundle("com/test/config/log4j");
        String key1 = resource1.getString("log4j.appender.file.File");
        System.out.println(key1);

        ResourceBundle resource2 = new PropertyResourceBundle(in);
        String key2 = resource2.getString("log4j.appender.file.File");
        System.out.println(key2);
    }

    /**
     * 利用Properties取数据
     */
    @Test
    public void testProperties2() throws IOException {
        //1.创建Properties集合对象
        Properties prop = new Properties();
        //2.使用Properties集合对象中的方法load读取保存键值对的文件
        String pathName = Constant.E_JAVA_TEST_TXT;
        prop.load(new FileReader(pathName));

        //使用stringPropertyNames把Properties集合中的键取出,存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();
        //3.遍历Properties集合
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /**
     * 利用Properties写数据
     */
    @Test
    public void testProperties1() throws IOException {
        //1.创建Properties集合对象,添加数据
        Properties prop = new Properties();
        prop.setProperty("赵丽颖", "168");
        prop.setProperty("迪丽热巴", "165");
        prop.setProperty("古力娜扎", "160");
        //2.创建字节输出流/字符输出流对象,构造方法中绑定要输出的目的地
        String pathName = Constant.E_JAVA_TEST_TXT;
        FileWriter fw = new FileWriter(pathName, true);
        //3.使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
        prop.store(fw, "save data");
        //4.释放资源
        fw.close();
    }
}
