package cn.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest1 {
    public static void main(String[] args) {
        List l=new ArrayList ();
        l.add ("hello");
        l.add ("world");
        l.add ("1");
        /*Iterator iterator = l.iterator ();
        while (iterator.hasNext ()){
            if(iterator.next ().equals ("hello")){
                l.add ("haha");  // java.util.ConcurrentModificationException  当对象检测到对象的并发修改，但不允许这种修改，抛出异常
                //迭代器依赖集合存在，在判断成功后，添加了新元素，但是迭代器自己却不知，所以发生了并发修改异常。
            }
        }*/
        System.out.println ("-----------方式一----------");  //查到之后立即加到后面
        ListIterator listIterator = l.listIterator ();
        while (listIterator.hasNext ()){
            if(listIterator.next ().equals ("hello")){
                listIterator.add ("javase");
                //[hello, java, world, 1]
            }
        }
        System.out.println (l);
        System.out.println ("-----------方式二----------"); //查到之后添加到尾部
        for (int i = 0; i <l.size () ; i++) {
            if (l.get (i).equals ("hello")){
                l.add ("java2e");
            }
        }
        System.out.println (l);
    }
}
