package com.springtest.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author admin
 * @date 2020/1/6 15:47
 */
public class SpringBeanMainTest {

    public static final String BEAN_NAME = "complexCollection";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        Object object = (ComplexAssembly) applicationContext.getBean(BEAN_NAME);
        System.out.println(((ComplexAssembly) object).getId() + "----" + ((ComplexAssembly) object).getList().toString());
        List<CusRole> roleList = ((ComplexAssembly) object).getRoleList();
        for (CusRole cusRole : roleList) {
            System.out.println(cusRole);
        }
        applicationContext.close();

    }

}
