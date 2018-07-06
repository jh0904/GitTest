package com.nio.test;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * com.nio.test
 *
 * @author jh
 * @date 2018/6/21 11:06
 * description:
 */
public class NioTest {

    public static void show(ByteBuffer bb) {
        System.out.println ("position---->" + bb.position ());
        System.out.println ("limit------->" + bb.limit ());
        System.out.println ("capacity---->" + bb.capacity ());
    }

    @Test
    public void test4() {
        String s = "abcde";
        String s1 = "abcde";
        String s2 = "abcd";
        ByteBuffer b1 = ByteBuffer.allocate (1024);
        ByteBuffer b2 = ByteBuffer.allocate (1024);
        ByteBuffer b3 = ByteBuffer.allocate (1024);
        b1.put (s.getBytes ());
        b2.put (s1.getBytes ());
        b3.put (s2.getBytes ());
        System.out.println ("-------equals--------");
        System.out.println (b1.equals (b2));
        System.out.println (b1.equals (b3));
        System.out.println ("-------compareTo--------");
        System.out.println (b1.compareTo (b2));
        System.out.println (b1.compareTo (b3));
        System.out.println (b3.compareTo (b1));
    }

    @Test
    public void test3() {
        ByteBuffer buffer = ByteBuffer.allocate (1024);

        System.out.println (buffer.isDirect ());
    }

    @Test
    public void test2() {
        String s = "abcde";
        ByteBuffer buf = ByteBuffer.allocate (1024);
        buf.put (s.getBytes ());
        buf.flip ();

        byte[] b = new byte[buf.limit ()];
        buf.get (b, 0, 2);
        System.out.println (new String (b, 0, 2));
        System.out.println (buf.position ());

        //mark() : 标记
        buf.mark ();

        buf.get (b, 2, 2);
        System.out.println (new String (b, 2, 2));
        System.out.println (buf.position ());

        System.out.println ("---------reset-----------");
        //reset() : 恢复到 mark 的位置
        buf.reset ();
        System.out.println (buf.position ());
        System.out.println ("---------hasRemaining-----------" + buf.hasRemaining ());
        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining ()) {

            //获取缓冲区中可以操作的数量
            System.out.println ("---------remaining-----------");
            System.out.println (buf.remaining ());
        }
    }

    @Test
    public void tets1() {
        /*
         *  1.分配一个指定大小的缓冲区
         */
        System.out.println ("--------allocate----------");
        ByteBuffer bb = ByteBuffer.allocate (1024);
        show (bb);

        /*
         *  2.利用put方法存入数据到缓冲区中去
         */
        String str = "hello";
        bb.put (str.getBytes ());

        System.out.println ("--------put----------");
        show (bb);
        /*
         *  3.切换数据模式
         */
        bb.flip ();
        System.out.println ("--------flip----------");
        show (bb);

        /*
         *  4.get读取数据
         */
        byte[] dst = new byte[bb.limit ()];
        bb.get (dst);
        System.out.println ("--------get----------");
        System.out.println (new String (dst));
        show (bb);

        /*
         *  5.rewind()方法
         */
        System.out.println ("--------rewind----------");
        bb.rewind ();
        show (bb);
        /*
         *  5.clear()方法
         */
        System.out.println ("--------clear----------");
        bb.clear ();
        show (bb);
    }
}
