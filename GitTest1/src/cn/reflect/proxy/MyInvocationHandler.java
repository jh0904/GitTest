package cn.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * cn.reflect.proxy
 *
 * @author jh
 * @date 2018/7/7 0:18
 * description:
 */
public class MyInvocationHandler implements InvocationHandler {
    private  Object tager;

    public MyInvocationHandler(Object tager) {
        this.tager = tager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println ("权限校验");
        Object result = method.invoke (tager, args);
        System.out.println ("日志记录");
        return result;
    }
}
