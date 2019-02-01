package com.tuling.dynamicproxy;

/**
 * Created by shanwei on 2019/2/1.
 */
public class Vendor implements Sell {

    @Override
    public void sell() {
        System.out.println("In sell Method");
    }

    @Override
    public void ad() {
        System.out.println("In ad method");
    }
}
