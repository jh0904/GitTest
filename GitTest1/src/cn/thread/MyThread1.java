package cn.thread;

/**
 * cn.thread
 *
 * @author jh
 * @date 2018/7/3 8:22
 * description:
 */
public class MyThread1 implements Runnable {
    private static int count =10000;
    private static Object obj=new Object ();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if (count > 0) {
                    System.out.println (Thread.currentThread ().getName ()+"正在售票--->"+(count--));
                }
            }
        }
    }
}
