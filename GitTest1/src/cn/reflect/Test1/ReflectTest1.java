package cn.reflect.Test1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * cn.reflect
 *
 * @author jh
 * @date 2018/7/6 19:48
 * description:配置文件中运行类中方法
 */
public class ReflectTest1 {
    public static void main(String[] args) throws Exception {


        Properties prop = new Properties ();
        FileReader fr = new FileReader ("jh.txt");
        prop.load (fr);
        fr.close ();


        String ClassName = prop.getProperty ("ClassName");
        String Method = prop.getProperty ("Method");


        Class c = Class.forName (ClassName);
        Constructor cc = c.getConstructor ();
        Object o = cc.newInstance ();
        Method method = c.getMethod (Method);

        method.invoke (o);

    }
}
