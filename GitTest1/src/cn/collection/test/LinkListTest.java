package cn.collection.test;

import java.awt.*;
import java.util.LinkedList;

public class LinkListTest {
    /*
     * LinkedList的特有功能：
     * 		A:添加功能
     * 			public void addFirst(Object e)
     * 			public void addLast(Object e)
     * 		B:获取功能
     * 			public Object getFirst()
     * 			public Obejct getLast()
     * 		C:删除功能
     * 			public Object removeFirst()
     * 			public Object removeLast()
     * */
    public static void main(String[] args) {
        LinkedList l = new LinkedList ();
        l.add ("aa");
        l.add ("bb");
        l.add ("cc");
        l.add ("dd");

        /*
         * A:添加功能
         * 			public void addFirst(Object e)
         * 			public void addLast(Object e)
         * */
       /* l.addFirst ("11"); //可以添加到第一个元素，实现先进后出

        l.addLast ("22");//作用不大，因为add()方法就是默认添加到最后一个。
        l.add ("33");*/

        /* B:获取功能
         * 			public Object getFirst()
         * 			public Obejct getLast()*/
       /* System.out.println (l.getFirst ());
        System.out.println (l.getLast ());*/

        /* C:删除功能
         * 			public Object removeFirst()
         * 			public Object removeLast()*/
        System.out.println ("remove-->"+l.removeFirst ());//返回的是被删除的元素

        for (Object o : l) {
            System.out.println (o);
        }
    }
}
