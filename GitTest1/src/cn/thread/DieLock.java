package cn.thread;

/**
 * cn.thread
 *
 * @author jh
 * @date 2018/7/3 19:27
 * description:
 */
public class DieLock implements Runnable {

    private boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA) {
                System.out.println ("if objA");
                synchronized (MyLock.objB) {
                    System.out.println ("if objB");
                }
            }
        } else {
            synchronized (MyLock.objB) {
                System.out.println ("else objB");
                synchronized (MyLock.objA) {
                    System.out.println ("else objA");
                }
            }
        }

    }
}
