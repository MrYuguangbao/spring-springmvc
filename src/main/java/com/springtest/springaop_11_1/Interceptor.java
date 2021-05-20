package com.springtest.springaop_11_1;

public interface Interceptor {
    void befor(Object obj);

    void after(Object obj);

    void afterReturning(Object obj);

    void afterThrowing(Object obj);
}
