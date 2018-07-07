package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:12
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {

        //获取参数（公共的）
        Class<?> c = Class.forName ("cn.reflect.Person");

        Object o = c.newInstance ();

        Method[] methods = c.getMethods ();
        for (Method method : methods) {
            System.out.println (method);
        }
        System.out.println ("--------------------");

        Method[] methods1 = c.getDeclaredMethods ();
        for (Method method : methods1) {
            System.out.println (method);
        }

        System.out.println ("--------------------");

        Method method = c.getMethod ("show");

        method.invoke (o);
        System.out.println ("--------------------");

        Method m = c.getMethod ("method",String.class);
        m.invoke (o,"--->");
    }
}
