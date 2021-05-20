package com.springtest.springaop_11_1;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 22:50
 */
public class ProxyBeanFactory {
    public static Object getBean(Object obj, Interceptor interceptor) {
        return ProxyBeanUtil.getBean(obj, interceptor);
    }
}
