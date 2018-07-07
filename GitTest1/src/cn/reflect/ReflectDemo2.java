package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:12
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {

        //获取多个参数的构造器
        Class<?> c = Class.forName ("cn.reflect.Person");

        Constructor con = c.getConstructor (String.class, int.class, String.class);

        Object o = con.newInstance ("蒋浩",22,"西安工业大学");

        System.out.println ((o).toString ());

        //获取私有的构造方法。java.lang.IllegalAccessException: Class cn.reflect.ReflectDemo2 can not access a member of class cn.reflect.Person with modifiers "private"

        Constructor<?> constructor = c.getDeclaredConstructor (String.class);
        //修改修饰符· 值为true则指示反射的对象正在使用时取消了java语言检查。
        constructor.setAccessible (true);

        Object o1 = constructor.newInstance ("magic");

        System.out.println (o1);



    }
}
