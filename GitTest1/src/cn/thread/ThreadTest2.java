package cn.thread;

/**
 * cn.thread
 *
 * @author jh
 * @date 2018/7/3 8:27
 * description:利用多线程实现看一个卖票机制，但是没有同步，里面有问题
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread1 my = new MyThread1 ();

        Thread t = new Thread (my, "一号窗口");
        Thread tt = new Thread (my, "二号窗口");
        Thread ttt = new Thread (my, "三号窗口");

        t.start ();
        tt.start ();
        ttt.start ();

    }
}
