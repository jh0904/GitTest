package cn.reflect.Test2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * cn.reflect.Test2
 *
 * @author jh
 * @date 2018/7/6 20:06
 * description:ArrayList如何存储String
 */
public class ArrayListDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arr=new ArrayList<> ();

        Class c = arr.getClass ();
        Method add = c.getMethod ("add",Object.class);
        arr.add (10);
        add.invoke (arr,"hello");

        System.out.println (arr);
    }
}
