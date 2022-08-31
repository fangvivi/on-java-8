package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author wayne
 */
public class ProxyFactory {

    /**
     * 被代理对象
     */
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        // 被代理对象的类加载器
        final ClassLoader classLoader = target.getClass().getClassLoader();
        // 被代理对象的类实现的接口
        final Class<?>[] interfaces = target.getClass().getInterfaces();
        // 增强逻辑
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("增强逻辑");
                method.invoke(target, args);
                return null;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

}
