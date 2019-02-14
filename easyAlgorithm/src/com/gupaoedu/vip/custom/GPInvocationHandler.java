package com.gupaoedu.vip.custom;

import java.lang.reflect.Method;

/**
 * Created by shanwei on 2019/2/14.
 */
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
