package com.gupaoedu.vip.custom;

import com.gupaoedu.vip.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * Created by shanwei on 2019/2/14.
 */
public class GPMeipo implements GPInvocationHandler {

    private Person target;

    public Object getInstance(Person target){

        this.target= target;
        Class clazz = target.getClass();
        System.out.println("被代理的class对象是："+clazz);
        return GPproxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，得给你找个异性才行！");
        System.out.println("开始进行海选...");
        System.out.println("--------------");
        method.invoke(this.target,args);
        System.out.println("--------------");
        System.out.println("如果合适的话，就准备办事！");
        return null;
    }
}
