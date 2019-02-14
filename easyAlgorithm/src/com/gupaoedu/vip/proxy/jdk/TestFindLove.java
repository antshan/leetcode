package com.gupaoedu.vip.proxy.jdk;

import com.gupaoedu.vip.custom.GPMeipo;

/**
 * Created by shanwei on 2019/2/14.
 */
public class TestFindLove {

    public static void main(String[] args){
        Person person =(Person) new GPMeipo().getInstance(new Xiaoxingxing());
        System.out.println(person.getClass());
        person.findLove();
    }
}
