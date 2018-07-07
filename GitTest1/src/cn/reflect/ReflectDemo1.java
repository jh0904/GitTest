package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:12
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName ("cn.reflect.Person");
        Constructor[] constructor = c.getConstructors ();
        for (Constructor con : constructor) {
            System.out.println (con);
        }

        System.out.println ("--------------------");
        Constructor[] conn = c.getDeclaredConstructors ();
        for (Constructor ccc : conn) {
            System.out.println (ccc);
        }
        System.out.println ("--------------------");

        //通过getConstructor获取无参构造器，并newInstanncwe()方法生成实例
        Constructor constructor1 = c.getConstructor ();

        Object o = constructor1.newInstance ();
        System.out.println (o);

       /* Person person = (Person) o;
        person.show ();*/

    }
}
