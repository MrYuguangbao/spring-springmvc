package com.springtest.aop.aop1;

/**
 * @author admin
 * @date 2019/8/6 18:09
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}
