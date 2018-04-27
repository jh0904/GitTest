package cn.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //List的特点：有序的Collection集合，可以重复，根据下标。ArrayList和Vector的区别是：ArrayList是线程不安全的，当多条线程访问同一个ArrayList集合时，程序需要手动保证该集合的同步性，而Vector则是线程安全的。
        List list=new ArrayList ();
        list.add ("1");
        list.add ("2");
        list.add ("3");
        list.add ("4");

        for (Iterator i = list.iterator ();i.hasNext ();){
            Object next = i.next ();
            System.out.println (next);
        }
    }
}
