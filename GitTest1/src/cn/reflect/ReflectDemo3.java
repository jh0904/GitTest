package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 16:12
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {

        //获取参数（公共的）
        Class<?> c = Class.forName ("cn.reflect.Person");
        Field[] fields = c.getFields ();
        for (Field field : fields) {
            System.out.println (field);
        }

        Field address = c.getField ("address");
        Constructor<?> constructor = c.getConstructor ();
        Object o = constructor.newInstance ();
        address.set(o,"户县");
        System.out.println (o);

        Field name = c.getDeclaredField("name");
        //取消java语法检查
        name.setAccessible (true);
        name.set(o,"jh");
        System.out.println (o);

        Field age = c.getDeclaredField("age");
        //取消java语法检查
        age.setAccessible (true);
        age.set(o,22);
        System.out.println (o);
    }
}
