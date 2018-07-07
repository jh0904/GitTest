package cn.reflect.proxy;

import java.lang.reflect.Proxy;

/**
 * cn.reflect.proxy
 *
 * @author jh
 * @date 2018/7/7 0:15
 * description:
 */
public class Test {
    public static void main(String[] args) {
        UserDao u=new UserDaoImpl ();
        u.add ();
        u.delete ();
        u.find ();
        u.update ();
        System.out.println ("------------");

        MyInvocationHandler handler = new MyInvocationHandler (u);

        UserDao proxy = (UserDao) Proxy.newProxyInstance (u.getClass ().getClassLoader (), u.getClass ().getInterfaces (), handler);
        proxy.update ();
        proxy.find ();
        proxy.delete ();
        proxy.add ();


    }
}
