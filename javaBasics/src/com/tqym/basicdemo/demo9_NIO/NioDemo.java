package com.tqym.basicdemo.demo9_NIO;

import com.tqym.utils.Constant;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @ClassName NioDemo
 * @Description 测试NIO
 * @Author 洛城天使
 * @Date: 2021/9/29 22:24
 * @Version 1.0
 */
public class NioDemo {

    /**
     * NIO复制文件
     */
    @Test
    public void testNIO() throws IOException {
        FileInputStream inputStream = new FileInputStream(Constant.C_COPY_KOBE1_JPG);
        FileChannel srcChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream(Constant.E_PATH + "bisTrans.jpg");
        FileChannel desChannel = outputStream.getChannel();

        /*ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            //重要操作，情况buffer，以便将数据重新写入buff
            buffer.clear();
            //将文件写入buff
            int read = srcChannel.read(buffer);
            if (read == -1) {
                break;
            }
            //buffer读写转换
            buffer.flip();
            //将数据从buff读出来，写入文件中
            desChannel.write(buffer);
        }*/

        desChannel.transferFrom(srcChannel, 0, srcChannel.size());
        outputStream.close();
        inputStream.close();
    }

}
