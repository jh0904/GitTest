package cn.collection.test;

import java.util.ArrayList;

public class ArrayListTest1 {
    //去除重复元素
    public static void main(String[] args) {
        ArrayList list=new ArrayList ();
        list.add ("aa");
        list.add ("dd");
        list.add ("cc");
        list.add ("aa");
        list.add ("dd");
        list.add ("cc");
        list.add ("cc");
        list.add ("aa");

        ArrayList newList=new ArrayList ();
        for (Object o:
             list) {
               if(!newList.contains (o)){
                   newList.add (o);
               }
        }
        for (Object o:
             newList) {
            System.out.println (o);
        }
    }
}
