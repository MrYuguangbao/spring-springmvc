package com.springtest.springaop_11_1;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 22:52
 */
public class PeopleInterceptor implements Interceptor {
    @Override
    public void befor(Object obj) {
        System.out.println("---------------- befor ------------- 准备打印");
    }

    @Override
    public void after(Object obj) {
        System.out.println("---------------- after ------------- 打印完毕");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("---------------- afterReturning ------------- 打印完毕，功能正常");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("---------------- afterThrowing ------------- 打印异常");
    }
}
