package cn.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        //List的特点：有序的Collection集合，可以重复，根据下标。ArrayList和Vector的区别是：ArrayList是线程不安全的，当多条线程访问同一个ArrayList集合时，程序需要手动保证该集合的同步性，而Vector则是线程安全的。list也是下标从0开始的；
        List list=new ArrayList ();
        list.add ("1");
        list.add ("2");
        list.add ("3");
        list.add ("4");

        //List的方法测试。
        System.out.println ("------2-------");
        for (Iterator i = list.iterator ();i.hasNext ();){
            Object next = i.next ();
            System.out.println (next);
        }
        System.out.println ("-------3-------");
        //List里面有get()方法；
        for (int i = 0; i < list.size (); i++) {
            System.out.println (list.get (i));
        }
        System.out.println ("-------remove-------");
        //Object remove = list.remove (3);  //返回的是删除的元素。
        //System.out.println (remove);
        System.out.println ("-------set-------");
        //Object set = list.set (0, "0");
        //System.out.println (set);//返回的也是改的对象。
        System.out.println ("-------subList-------");
        list.add ("5");
        list.add ("6");
        list.add ("7");
        List list1 = list.subList (1, 4);//截取list集合的一段。并返回
        for (Object o:list1) {
            System.out.println (o);
        }
        System.out.println ("-listiterator--");

        //listiterator
        ListIterator listIterator = list.listIterator ();
        while (listIterator.hasNext ()){
            Object next = listIterator.next ();
            System.out.println (next);

        }
        System.out.println ("------listIterator（2）-------");
        ListIterator listIterator1 = list.listIterator (2);//表示从第几个下标开始遍历
        while (listIterator1.hasNext ()){
            Object next = listIterator1.next ();
            System.out.println (next);
        }
        System.out.println ("------previous-------");
        while (listIterator.hasPrevious ()){
            Object next = listIterator1.previous ();//倒序输出；但是必须先正向遍历，在逆序遍历，无意义；
            System.out.println (next);
        }
    }
}
