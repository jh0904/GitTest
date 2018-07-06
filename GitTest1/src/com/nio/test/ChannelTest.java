package com.nio.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * com.nio.test
 *
 * @author jh
 * @date 2018/6/22 16:34
 * description:
 */
public class ChannelTest {

   @Test
   public void test3() throws IOException {
       FileChannel inChannel = FileChannel.open(Paths.get("aa.jpg"), StandardOpenOption.READ);
       FileChannel outChannel = FileChannel.open(Paths.get("d:/3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

      //inChannel.transferTo (0, inChannel.size (), outChannel);
        outChannel.transferFrom (inChannel,0,inChannel.size ());
      inChannel.close ();
      outChannel.close ();
   }


    @Test
    /**
     * 利用直接缓冲区（只有ByteBuffer支持）完成文件的复制（内存映射文件）
     *
     *java.io.IOException: Map failed
     * 错误提示，oom，加大xmx，xmx（32位jdk）过大时报错：
     *
     *
     * Error occurred during initialization of VM
     *
     * Could not reserve enough space for object heap
     *
     * Java Virtual Machine Launcher
     * ---------------------------
     * Could not create the Java virtual machine.
     * ---------------------------
     * 确定
     * ---------------------------
     * 内存设置过大，jvm启动失败；
     *
     * 换64位jdk，在eclipse地下运行，发现仍然无法设置过大xmx
     *
     * 选择eclipse-->run configurations-->具体application-->jre，修改jdk即可解决。
     * */
    public void test2() throws IOException {

        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("d:/aa.mkv"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d:/2.mkv"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        /*
         * StandardOpenOption.CREATE----------->不存在就创建，存在就覆盖
         * StandardOpenOption.CREATE_NEW----------->不存在就创建，存在就报错
         */

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));


    }



    @Test
    /**
     * 1.利用通道复制文件（非直接缓冲区）
     * */
    public void test1() throws IOException {
        //时间---》11176  时间---》10331  时间---》10210  时间---》10938
        long l = System.currentTimeMillis ();

        FileInputStream fis = new FileInputStream ("d:/aa.mkv");
        FileOutputStream fos = new FileOutputStream ("d:/11.mkv");
        //1.获取通道
        FileChannel fisChannel = fis.getChannel ();
        FileChannel fosChannel = fos.getChannel ();
        //2.分配指定大小缓冲区
        ByteBuffer buffer = ByteBuffer.allocate (1024);
        //3.将同道中的数据存入缓冲区
        while (fisChannel.read (buffer) != -1) {
            buffer.flip ();//切换成读数据模式
            //4.将缓冲区数据写入通道
            fosChannel.write (buffer);
            buffer.clear ();//清空缓冲区
        }
        if (fosChannel != null) {
            fosChannel.close ();
        }
        if (fisChannel != null) {
            fisChannel.close ();
        }
        if (fos != null) {
            fos.close ();
        }
        if (fis != null) {
            fis.close ();
        }

        long l1 = System.currentTimeMillis ();

        System.out.println ("时间---》"+(l1-l));
    }
}
