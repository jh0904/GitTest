package cn.reflect.Test3;

import java.lang.reflect.Field;

/**
 * cn.reflect.Test3
 *
 * @author jh
 * @date 2018/7/6 20:16
 * description:
 * public void setProperty(Object obj, String propertyName, Object value){}，
 * 此方法可将obj对象中名为propertyName的属性的值设置为value。
 */
public class Tool {
    public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        //根据对象获取字节码文件
        Class c = obj.getClass ();
        //获取propertyName成员变量
        Field field = c.getDeclaredField (propertyName);
        //暴力访问
        field.setAccessible (true);
        //给对象赋值
        field.set (obj,value);
    }
}
