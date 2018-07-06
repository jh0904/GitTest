package cn.thread;

import org.junit.Test;

/**
 * cn.thread
 *
 * @author jh
 * @date 2018/7/2 18:18
 * description:实现Thread方法，继承Thread类，然后再去重写run（）方法。
 * 不是所有类需要被多线程执行，run（）方法里面是被线程执行的代码。
 */
public class ThreadTest1 extends Thread {

    @Override
    public void run() {
        int count=1000;
        for (int i = 0; i < count; i++) {
            System.out.println (getName ()+"------>"+i);
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
/**
* getName ()源码
public Thread() {
         init(null, null, "Thread-" + nextThreadNum(), 0);
     }

* */
    public static void main(String[] args) {
        ThreadTest1 t = new ThreadTest1 ();
        ThreadTest1 t1 = new ThreadTest1 ();

        t.setName ("magic");
        t1.setName ("jh");

       /*
        启动线程
        t.run ();
        t.run ();*/

        // java.lang.IllegalThreadStateException(非法的状态异常，相当于main线程启动了两次)
       /* t.start ();
        t.start ();*/

       //如何获取线程的名称  public String getName()
        t.start ();
        t1.start ();


        /*
         * run方法调用就相当于普通方法的调用，单线程的执行
         * 面试题：start和run的区别：
         * run：仅仅是封装被线程执行的代码，直接是调用是普通方法。
         * start：首先启动线程，然后再由JVM虚拟机调用该线程的run（）方法。
         */
    }
}
