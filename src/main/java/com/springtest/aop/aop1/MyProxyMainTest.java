package com.springtest.aop.aop1;

import com.springtest.RoleVO;

/**
 * @author admin
 * @date 2019/8/6 18:17
 */
public class MyProxyMainTest {

    public static void main(String[] args) {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();

        RoleService proxy = ProxyBeanFactory.getBean(roleService, interceptor);
        System.out.println("*********************测试正常的情况******************");
        proxy.print(new RoleVO());
        System.out.println("*********************测试异常的情况******************");
        proxy.print(null);


    }

}
