package com.tuling.dynamicproxy;

/**
 * Created by shanwei on 2019/2/1.
 */
public class BusinessAgent implements Sell {

    @Override
    public void sell() {
        System.out.println("BA sell method");
    }

    @Override
    public void ad() {
        System.out.println("BA ad method");
    }
}
