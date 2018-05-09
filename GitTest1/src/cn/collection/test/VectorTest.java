package cn.collection.test;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        /*
        *  对Vector的一个简单使用
        * */
        Vector v=new Vector ();
        v.addElement ("hello");   //-------------->add()
        v.addElement ("world");
        v.addElement ("java");

        System.out.println (v.elementAt (1));//下标从0开始 //-------------->get()
        System.out.println ("-----------------");
        Enumeration elements = v.elements ();   //-------------->Iterator()
        while (elements.hasMoreElements ()){    //-------------->hasNext()
            Object o = elements.nextElement (); //-------------->next()
            System.out.println (o);
        }


    }
}
