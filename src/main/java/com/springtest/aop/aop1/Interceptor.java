package com.springtest.aop.aop1;

public interface Interceptor {

    void before(Object object);

    void after(Object object);

    void afterReturning(Object object);

    void afterThrowing(Object object);

}
