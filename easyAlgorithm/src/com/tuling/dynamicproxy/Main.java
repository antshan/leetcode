package com.tuling.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by shanwei on 2019/2/1.
 */
public class Main {

    public static void main(String[] args){

        //动态代理，实现Sell接口实现类的代理类
        DynamicProxy dynamicProxy= new DynamicProxy(new BusinessAgent());
        Sell sell= (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class<?>[]{Sell.class},dynamicProxy);
        sell.sell();
        sell.ad();

        System.out.println();
        System.out.println();
        System.out.println();

        DynamicProxy dynamicProxy1= new DynamicProxy(new Vendor());
        Sell sell1= (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class<?>[]{Sell.class},dynamicProxy1);
        sell1.sell();
        sell1.ad();
    }
}
