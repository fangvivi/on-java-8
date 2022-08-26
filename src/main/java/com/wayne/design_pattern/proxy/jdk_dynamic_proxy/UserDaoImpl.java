package com.wayne.design_pattern.proxy.jdk_dynamic_proxy;

/**
 * @author wayne
 */
public class UserDaoImpl implements UserDao{
    /**
     * 这个方法会被代理对象增强
     */
    @Override
    public void save() {
        System.out.println("保存用户数据");
    }
}
