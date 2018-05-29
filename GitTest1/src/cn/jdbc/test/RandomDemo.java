package cn.jdbc.test;

import java.util.ArrayList;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r=new Random ();
        ArrayList<Integer> list=new ArrayList ();
        int count=0;
        while(count<10){
            int i = r.nextInt (20)+1;
            if(!list.contains (i)){
                list.add (i);
                count++;
            }
        }
        for (Integer x:list) {
            System.out.println (x);
        }
    }
}
