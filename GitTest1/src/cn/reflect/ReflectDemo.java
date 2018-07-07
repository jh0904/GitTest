package cn.reflect;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:12
 * description:对于反射的一些简单操作。
 * 反射的几种方式
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p = new Person ();
        Class c = p.getClass ();

        Person p2 = new Person ();
        Class c2 = p2.getClass ();
        /*
        false
        true
        */
        System.out.println (p == p2);
        System.out.println (c == c2);


        Class c3 = Person.class;
        System.out.println (c3 == c);

        Class<?> c4 = Class.forName ("cn.reflect.Person");
        System.out.println (c4 == c);
    }
}
