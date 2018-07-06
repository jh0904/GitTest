package cn.cn.LinkList.test;

import com.sample.User;

import java.util.*;

public class LinkListTest {

    public static void main(String[] args) {
      /*  List l = new LinkedList ();
        ArrayList<Integer> list=new ArrayList<Integer> ();
        list.add (1);
        list.add (2);
        list.add (3);
        System.out.println (list.toString ());
        User u=new User ();*/
        LinkedHashSet  lhs = new LinkedHashSet ();
        lhs.add (1);
        lhs.add (2);
        lhs.add (3);
        lhs.add (4);
        lhs.add (5);
        lhs.add (6);
        lhs.add (1);
        for (Object lh : lhs) {
            System.out.println (lh);
        }
        System.out.println ();
        System.out.println ();
    }

}
