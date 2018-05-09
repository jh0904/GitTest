package cn.collection.test;

import java.util.ArrayList;

public class ArrayListTest2 {
    //去除重复元素
    public static void main(String[] args) {
        {
            ArrayList list=new ArrayList ();
            list.add ("aa");
            list.add ("dd");
            list.add ("cc");
            list.add ("aa");
            list.add ("dd");
            list.add ("cc");
            list.add ("cc");
            list.add ("aa");

            for (int i = 0; i <list.size ()-1 ; i++) {
                for (int j = i+1; j <list.size () ; j++) {
                    if(list.get (i).equals (list.get (j)) ){
                        list.remove (j);
                        j--;    //如果有多个连续的重复元素，j位置的北移除，下一个元素补上来，就会被忽略，直接去j+1个元素，所以j--可以扫描所有元素
                    }
                }
            }
            for (Object o:list) {
                System.out.println (o);
            }
        }
    }
}
